package module

import akka.actor.Actor
import play.api._
import play.api.mvc._
import play.api.libs.json.Json
import play.api.libs.json.Json.{ toJson }
import play.api.libs.json.{ JsValue, JsObject, JsString, JsArray }
import play.api.libs.iteratee._
import play.api.libs.concurrent._
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits._
import akka.actor.Props
import akka.pattern.ask
import akka.util.Timeout

// messages
case class register(user_id: String) 												// message for register a user
case class unRegister(user_id: String)												// message for quit the chat service
case class channelCreated(user_id: String, channel: Concurrent.Channel[JsValue])	// message for channel created
case class pushNotification(user_id: String, text: String)							// message for push messages
case class registerCallback(user_id: String)										// message for register callback

case class Connected(enumerator:Enumerator[JsValue])								// connect success
case class CannotConnect(msg: String)												// connect not success

class ChatNotifycationCenter extends Actor {

	var registration_list = Map.empty[String,  Option[Concurrent.Channel[JsValue]]]
	
//	var channel : Option[Concurrent.Channel[JsValue]] = null
	def receive = {
	  case register(user_id) =>
		  // Create an Enumerator to write to this socket
		  val enumerator =  Concurrent.unicast[JsValue] { x => 
		    	self ! channelCreated(user_id, x)
		  }
		 
		  if(registration_list.contains(user_id)) {
			  sender ! CannotConnect("This username is already used")
		  } else {
			  sender ! Connected(enumerator)
		  }    
	  
	  case channelCreated(user_id, channel) => 
			registration_list = registration_list + (user_id -> Some(channel))
	  
	  case unRegister(user_id) => 
		  registration_list = registration_list - user_id
	  
	  case pushNotification(user_id, text) =>
		  notifyImpl(user_id, text)
	}
	
	def notifyImpl(user_id : String, text : String) = {
		
		val msg = JsObject(
			Seq(
				"user" -> JsString(user_id),
				"message" -> JsString(text),
				"members" -> JsArray(
						registration_list.keySet.toList.map(JsString)
						)
					)
			)
		registration_list.foreach { 
			case (s, channel) => { channel.foreach(_.push(msg)) }
		}
	}
}

class MessageNotificationModule (implicit app: Application) {
	
	lazy val defaultNotificationCenter = Akka.system.actorOf(Props[ChatNotifycationCenter])
	
	implicit val timeout = Timeout(1 second)
	
	def connectWs(user_id : String) : WebSocket[JsValue] = WebSocket.async[JsValue]{ request =>
      	(defaultNotificationCenter ? register(user_id)).map {

        case Connected(enumerator:Enumerator[JsValue]) =>
        	val iteratee = Iteratee.foreach[JsValue] { event =>
        	defaultNotificationCenter ! pushNotification(user_id, (event \ "text").as[String]) 
          }.map { _ =>
            defaultNotificationCenter ! unRegister(user_id)
          }
          (iteratee, enumerator)

        case CannotConnect(error) =>
          // Connection error

          // A finished Iteratee sending EOF
          val iteratee = Done[JsValue, Unit]((), Input.EOF)

          // Send an error and close the socket
          val enumerator = Enumerator[JsValue](JsObject(Seq("error" -> JsString(error)))).andThen(Enumerator.enumInput(Input.EOF))

          (iteratee, enumerator)
      }
    }
}

object MessageNotificationModule {
	def apply()(implicit app: Application) : MessageNotificationModule = new MessageNotificationModule()(app)
}