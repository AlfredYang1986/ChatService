// @SOURCE:/Users/yangyuan/Desktop/ChatService2/conf/routes
// @HASH:a1bea8efbae56e0eb56b3571b90e3fb53cd341c7
// @DATE:Tue May 05 14:19:34 HKT 2015


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_messageController_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:9
private[this] lazy val controllers_messageController_loginWithName1 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("loginWithName"))))
        

// @LINE:12
private[this] lazy val controllers_messageController_sendMessage2 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("sendMessage"))))
        

// @LINE:13
private[this] lazy val controllers_messageController_queryMessages3 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("queryMessages"))))
        

// @LINE:14
private[this] lazy val controllers_messageController_queryMessagesWithFriend4 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("queryMessagesWithFriend"))))
        

// @LINE:15
private[this] lazy val controllers_messageController_regiterWithDevice5 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("registerDevice"))))
        

// @LINE:18
private[this] lazy val controllers_messageController_addOneFriend6 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("addOneFriend"))))
        

// @LINE:19
private[this] lazy val controllers_messageController_deleteOneFriend7 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deleteOneFriend"))))
        

// @LINE:20
private[this] lazy val controllers_messageController_queryAllFriend8 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("queryAllFriend"))))
        

// @LINE:23
private[this] lazy val controllers_Assets_at9 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix,"""controllers.messageController.index"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """loginWithName""","""controllers.messageController.loginWithName"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """sendMessage""","""controllers.messageController.sendMessage"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """queryMessages""","""controllers.messageController.queryMessages"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """queryMessagesWithFriend""","""controllers.messageController.queryMessagesWithFriend"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """registerDevice""","""controllers.messageController.regiterWithDevice"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """addOneFriend""","""controllers.messageController.addOneFriend"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deleteOneFriend""","""controllers.messageController.deleteOneFriend"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """queryAllFriend""","""controllers.messageController.queryAllFriend"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_messageController_index0(params) => {
   call { 
        invokeHandler(controllers.messageController.index, HandlerDef(this, "controllers.messageController", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:9
case controllers_messageController_loginWithName1(params) => {
   call { 
        invokeHandler(controllers.messageController.loginWithName, HandlerDef(this, "controllers.messageController", "loginWithName", Nil,"POST", """ login""", Routes.prefix + """loginWithName"""))
   }
}
        

// @LINE:12
case controllers_messageController_sendMessage2(params) => {
   call { 
        invokeHandler(controllers.messageController.sendMessage, HandlerDef(this, "controllers.messageController", "sendMessage", Nil,"POST", """ message""", Routes.prefix + """sendMessage"""))
   }
}
        

// @LINE:13
case controllers_messageController_queryMessages3(params) => {
   call { 
        invokeHandler(controllers.messageController.queryMessages, HandlerDef(this, "controllers.messageController", "queryMessages", Nil,"POST", """""", Routes.prefix + """queryMessages"""))
   }
}
        

// @LINE:14
case controllers_messageController_queryMessagesWithFriend4(params) => {
   call { 
        invokeHandler(controllers.messageController.queryMessagesWithFriend, HandlerDef(this, "controllers.messageController", "queryMessagesWithFriend", Nil,"POST", """""", Routes.prefix + """queryMessagesWithFriend"""))
   }
}
        

// @LINE:15
case controllers_messageController_regiterWithDevice5(params) => {
   call { 
        invokeHandler(controllers.messageController.regiterWithDevice, HandlerDef(this, "controllers.messageController", "regiterWithDevice", Nil,"POST", """""", Routes.prefix + """registerDevice"""))
   }
}
        

// @LINE:18
case controllers_messageController_addOneFriend6(params) => {
   call { 
        invokeHandler(controllers.messageController.addOneFriend, HandlerDef(this, "controllers.messageController", "addOneFriend", Nil,"POST", """ friends""", Routes.prefix + """addOneFriend"""))
   }
}
        

// @LINE:19
case controllers_messageController_deleteOneFriend7(params) => {
   call { 
        invokeHandler(controllers.messageController.deleteOneFriend, HandlerDef(this, "controllers.messageController", "deleteOneFriend", Nil,"POST", """""", Routes.prefix + """deleteOneFriend"""))
   }
}
        

// @LINE:20
case controllers_messageController_queryAllFriend8(params) => {
   call { 
        invokeHandler(controllers.messageController.queryAllFriend, HandlerDef(this, "controllers.messageController", "queryAllFriend", Nil,"POST", """""", Routes.prefix + """queryAllFriend"""))
   }
}
        

// @LINE:23
case controllers_Assets_at9(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}

}
     