// @SOURCE:/Users/yangyuan/Desktop/ChatService2/conf/routes
// @HASH:dced01347a221279e4d7daea8e12ef647e871118
// @DATE:Thu May 07 11:07:02 HKT 2015

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString


// @LINE:25
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:17
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:9
// @LINE:6
package controllers {

// @LINE:17
class ReverseMessageNotificationController {
    

// @LINE:17
def registerDevice(user_id:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "registerDevice/" + implicitly[PathBindable[String]].unbind("user_id", dynamicString(user_id)))
}
                                                
    
}
                          

// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:9
// @LINE:6
class ReversemessageController {
    

// @LINE:12
def sendMessage(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "sendMessage")
}
                                                

// @LINE:20
def addOneFriend(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "addOneFriend")
}
                                                

// @LINE:13
def queryMessages(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "queryMessages")
}
                                                

// @LINE:21
def deleteOneFriend(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "deleteOneFriend")
}
                                                

// @LINE:22
def queryAllFriend(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "queryAllFriend")
}
                                                

// @LINE:9
def loginWithName(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "loginWithName")
}
                                                

// @LINE:14
def queryMessagesWithFriend(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "queryMessagesWithFriend")
}
                                                

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                
    
}
                          

// @LINE:25
class ReverseAssets {
    

// @LINE:25
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          
}
                  


// @LINE:25
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:17
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:9
// @LINE:6
package controllers.javascript {

// @LINE:17
class ReverseMessageNotificationController {
    

// @LINE:17
def registerDevice : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.MessageNotificationController.registerDevice",
   """
      function(user_id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "registerDevice/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("user_id", encodeURIComponent(user_id))})
      }
   """
)
                        
    
}
              

// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:9
// @LINE:6
class ReversemessageController {
    

// @LINE:12
def sendMessage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.messageController.sendMessage",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "sendMessage"})
      }
   """
)
                        

// @LINE:20
def addOneFriend : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.messageController.addOneFriend",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addOneFriend"})
      }
   """
)
                        

// @LINE:13
def queryMessages : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.messageController.queryMessages",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "queryMessages"})
      }
   """
)
                        

// @LINE:21
def deleteOneFriend : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.messageController.deleteOneFriend",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteOneFriend"})
      }
   """
)
                        

// @LINE:22
def queryAllFriend : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.messageController.queryAllFriend",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "queryAllFriend"})
      }
   """
)
                        

// @LINE:9
def loginWithName : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.messageController.loginWithName",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "loginWithName"})
      }
   """
)
                        

// @LINE:14
def queryMessagesWithFriend : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.messageController.queryMessagesWithFriend",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "queryMessagesWithFriend"})
      }
   """
)
                        

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.messageController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        
    
}
              

// @LINE:25
class ReverseAssets {
    

// @LINE:25
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              
}
        


// @LINE:25
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:17
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:9
// @LINE:6
package controllers.ref {


// @LINE:17
class ReverseMessageNotificationController {
    

// @LINE:17
def registerDevice(user_id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.MessageNotificationController.registerDevice(user_id), HandlerDef(this, "controllers.MessageNotificationController", "registerDevice", Seq(classOf[String]), "GET", """ message websocket""", _prefix + """registerDevice/$user_id<[^/]+>""")
)
                      
    
}
                          

// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:9
// @LINE:6
class ReversemessageController {
    

// @LINE:12
def sendMessage(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.messageController.sendMessage(), HandlerDef(this, "controllers.messageController", "sendMessage", Seq(), "POST", """ message""", _prefix + """sendMessage""")
)
                      

// @LINE:20
def addOneFriend(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.messageController.addOneFriend(), HandlerDef(this, "controllers.messageController", "addOneFriend", Seq(), "POST", """ friends""", _prefix + """addOneFriend""")
)
                      

// @LINE:13
def queryMessages(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.messageController.queryMessages(), HandlerDef(this, "controllers.messageController", "queryMessages", Seq(), "POST", """""", _prefix + """queryMessages""")
)
                      

// @LINE:21
def deleteOneFriend(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.messageController.deleteOneFriend(), HandlerDef(this, "controllers.messageController", "deleteOneFriend", Seq(), "POST", """""", _prefix + """deleteOneFriend""")
)
                      

// @LINE:22
def queryAllFriend(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.messageController.queryAllFriend(), HandlerDef(this, "controllers.messageController", "queryAllFriend", Seq(), "POST", """""", _prefix + """queryAllFriend""")
)
                      

// @LINE:9
def loginWithName(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.messageController.loginWithName(), HandlerDef(this, "controllers.messageController", "loginWithName", Seq(), "POST", """ login""", _prefix + """loginWithName""")
)
                      

// @LINE:14
def queryMessagesWithFriend(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.messageController.queryMessagesWithFriend(), HandlerDef(this, "controllers.messageController", "queryMessagesWithFriend", Seq(), "POST", """""", _prefix + """queryMessagesWithFriend""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.messageController.index(), HandlerDef(this, "controllers.messageController", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      
    
}
                          

// @LINE:25
class ReverseAssets {
    

// @LINE:25
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          
}
        
    