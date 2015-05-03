// @SOURCE:/Users/yangyuan/Desktop/ChatService/conf/routes
// @HASH:3f58788c03b1ff5bada86d7bbe33ccd17d838f16
// @DATE:Sun May 03 20:17:41 HKT 2015


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
        

// @LINE:8
private[this] lazy val controllers_messageController_loginWithName1 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("loginWithName"))))
        

// @LINE:9
private[this] lazy val controllers_messageController_sendMessage2 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("sendMessage"))))
        

// @LINE:10
private[this] lazy val controllers_messageController_queryMessages3 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("queryMessages"))))
        

// @LINE:11
private[this] lazy val controllers_messageController_regiterWithDevice4 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("registerDevice"))))
        

// @LINE:14
private[this] lazy val controllers_Assets_at5 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix,"""controllers.messageController.index"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """loginWithName""","""controllers.messageController.loginWithName"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """sendMessage""","""controllers.messageController.sendMessage"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """queryMessages""","""controllers.messageController.queryMessages"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """registerDevice""","""controllers.messageController.regiterWithDevice"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
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
        

// @LINE:8
case controllers_messageController_loginWithName1(params) => {
   call { 
        invokeHandler(controllers.messageController.loginWithName, HandlerDef(this, "controllers.messageController", "loginWithName", Nil,"POST", """""", Routes.prefix + """loginWithName"""))
   }
}
        

// @LINE:9
case controllers_messageController_sendMessage2(params) => {
   call { 
        invokeHandler(controllers.messageController.sendMessage, HandlerDef(this, "controllers.messageController", "sendMessage", Nil,"POST", """""", Routes.prefix + """sendMessage"""))
   }
}
        

// @LINE:10
case controllers_messageController_queryMessages3(params) => {
   call { 
        invokeHandler(controllers.messageController.queryMessages, HandlerDef(this, "controllers.messageController", "queryMessages", Nil,"POST", """""", Routes.prefix + """queryMessages"""))
   }
}
        

// @LINE:11
case controllers_messageController_regiterWithDevice4(params) => {
   call { 
        invokeHandler(controllers.messageController.regiterWithDevice, HandlerDef(this, "controllers.messageController", "regiterWithDevice", Nil,"POST", """""", Routes.prefix + """registerDevice"""))
   }
}
        

// @LINE:14
case controllers_Assets_at5(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}

}
     