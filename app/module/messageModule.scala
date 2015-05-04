package module

import play.api.libs.json.Json
import play.api.libs.json.Json.{toJson}
import play.api.libs.json.JsValue
import play.api.http.Writeable
import util.dao.from
import util.dao._data_connection
import util.errorcode.ErrorCode
import com.mongodb.casbah.Imports._

import java.util.Date

object messageModule {

	// Login
	def loginWithName(data : JsValue) : JsValue = {
		
		val user_id= (data \ "user_id").asOpt[String].get
		
		val rel = from db() in "users" where ("user_id" -> user_id) select (x => x)
		if (!rel.empty) {
			Json.toJson(Map("status" -> toJson("ok"), "result" -> 
				toJson(Map("user_id" -> toJson(user_id)))))
		} else {
			val builder = MongoDBObject.newBuilder
			builder += "user_id" -> user_id
			val friend_list = MongoDBList.newBuilder
			builder += "friends" -> friend_list.result
		
			_data_connection.getCollection("users") += builder.result
			/**
			 * return 
			 */
			Json.toJson(Map("status" -> toJson("ok"), "result" -> 
				toJson(Map("user_id" -> toJson(user_id)))))
		}
	}

	// Friends
	def addOneFriend(data : JsValue) : JsValue = {

		val user_id = (data \ "user_id").asOpt[String].get
		val friend_id = (data \ "friend_id").asOpt[String].get
	
		val user_ref = (from db() in "users" where "user_id" -> user_id select (x => x)).head
		val friend_ref = (from db() in "users" where "user_id" -> friend_id select (x => x)).head
	
		user_ref.getAs[MongoDBList]("friends").map { x => 
		  	if (x.contains(friend_id)) //ErrorCode.errorToJson("already friends")
		  		queryFriends(data)
		  	else {
		  		x += friend_id
		  		_data_connection.getCollection("users").update(DBObject("user_id" -> user_id), user_ref)
		  		
		  		friend_ref.getAs[MongoDBList]("friends").map { y =>
		  		  	y += user_id
		  		  	_data_connection.getCollection("users").update(DBObject("user_id" -> friend_id), friend_ref)
		  		}.getOrElse(throw new Exception)
		  		queryFriends(data)
		  	}
		}.getOrElse(throw new Exception)
	}
	
	def deleteOneFriend(data : JsValue) = {
	
		val user_id = (data \ "user_id").asOpt[String].get
		val friend_id = (data \ "friend_id").asOpt[String].get
	
		val user_ref = (from db() in "users" where "user_id" -> user_id select (x => x)).head
		val friend_ref = (from db() in "users" where "user_id" -> friend_id select (x => x)).head
	
		user_ref.getAs[MongoDBList]("friends").map { x => 
		  	if (x.contains(friend_id)) {
		  		user_ref.update("friends", x.filter(_ != friend_id))
		  		_data_connection.getCollection("users").update(DBObject("user_id" -> user_id), user_ref)
		  		
		  		friend_ref.getAs[MongoDBList]("friends").map { y =>
		  			friend_ref.update("friends", y.filter(_ != user_id))
		  		  	_data_connection.getCollection("users").update(DBObject("user_id" -> friend_id), friend_ref)
		  		}.getOrElse(throw new Exception)
		  		queryFriends(data)
		  	} else queryFriends(data)
		  	
		}.getOrElse(throw new Exception)  
	}
	
	def queryFriends(data : JsValue) : JsValue = {

		val user_id = (data \ "user_id").asOpt[String].get
		val user_ref = (from db() in "users" where "user_id" -> user_id select (x => x)).head
	
		var re : List[JsValue] = Nil
		user_ref.getAs[MongoDBList]("friends").map { x => 
		 	x.toSeq.map { it => 
		 		re = toJson(it.asInstanceOf[String]) :: re
		 	}
		  
		}.getOrElse(throw new Exception)

		Json.toJson(Map("status" -> toJson("ok"), "result" -> toJson(Map("friends" -> toJson(re)))))
	}

	// Messages
	def regiterWithDevice(data : JsValue) : JsValue = null
	
	def sendMessage(data : JsValue) : JsValue = {
		
		val user_id = (data \ "user_id").asOpt[String].get
		val date = new Date().getTime
		val receiver = (data \ "receiver").asOpt[String].get
		val message_type = (data \ "message_type").asOpt[String].get
		val message_content = (data \ "message_content").asOpt[String].get
	
		val collection_name = "chat_history"
		
		val builder = MongoDBObject.newBuilder
		builder += "sender" -> user_id
		builder += "receiver" -> receiver
		builder += "message_type" -> message_type
		builder += "message_content" -> message_content
	 
		_data_connection.getCollection(collection_name) += builder.result
		/**
		 * return 
		 */
		Json.toJson(Map("status" -> toJson("ok"), "result" -> 
				toJson(Map("status" -> toJson("success")))))	
	}
	
	def queryMessages(data : JsValue) : JsValue = {

		val user_id = (data \ "user_id").asOpt[String].get

		def getField(obj : MongoDBObject, name : String) = obj.get(name).map(_.asInstanceOf[String]).getOrElse(throw new Exception)
		def getSender(x : MongoDBObject) : String = getField(x, "sender")
		def getReceiver(x : MongoDBObject) : String =getField(x, "receiver") 
		def getMessageType(x : MongoDBObject) : String = getField(x, "message_type")
		def getMessageContent(x : MongoDBObject) : String = getField(x, "message_content")
		def target(x : MongoDBObject) : String = {
		  	if (getSender(x) == user_id) getReceiver(x) else getSender(x)
		}
		
		val date = (data \ "date").asOpt[String].get
		val collection_name = "chat_history"

		val result = from db() in collection_name where ($or("sender" -> user_id, "receiver" -> user_id)) select (x => x)

		var resultMap : Map[String, List[JsValue]] = Map.empty
		result.toList.distinct map { x =>
			resultMap.get(target(x)).map {
				lt => 
					resultMap += (target(x) -> lt )
						lt :+ toJson(Map("sender" -> toJson(getSender(x)), "receiver" -> toJson(getReceiver(x)), 
								"message_type" -> toJson(getMessageType(x)), "message_content" -> toJson(getMessageContent(x))))
			}.getOrElse{
					resultMap += target(x) -> (toJson(Map("sender" -> toJson(getSender(x)), "receiver" -> toJson(getReceiver(x)), 
								"message_type" -> toJson(getMessageType(x)), "message_content" -> toJson(getMessageContent(x)))) :: Nil)
			}
		}
		
		Json.toJson(Map("status" -> toJson("ok"), "result" -> toJson(resultMap)))
	}
}