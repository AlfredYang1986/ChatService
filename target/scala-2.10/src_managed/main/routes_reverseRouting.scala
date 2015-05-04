// @SOURCE:/Users/yangyuan/Desktop/ChatService2/conf/routes
// @HASH:be40b73cd91861aeb43fa4601787831ee52bd81d
// @DATE:Mon May 04 21:50:59 HKT 2015

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString


// @LINE:20
// @LINE:17
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:9
// @LINE:6
package controllers {

// @LINE:17
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
                                                

// @LINE:17
def addOneFriend(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "addOneFriend")
}
                                                

// @LINE:14
def regiterWithDevice(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "registerDevice")
}
                                                

// @LINE:13
def queryMessages(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "queryMessages")
}
                                                

// @LINE:9
def loginWithName(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "loginWithName")
}
                                                

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                
    
}
                          

// @LINE:20
class ReverseAssets {
    

// @LINE:20
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          
}
                  


// @LINE:20
// @LINE:17
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:9
// @LINE:6
package controllers.javascript {

// @LINE:17
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
                        

// @LINE:17
def addOneFriend : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.messageController.addOneFriend",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addOneFriend"})
      }
   """
)
                        

// @LINE:14
def regiterWithDevice : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.messageController.regiterWithDevice",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "registerDevice"})
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
                        

// @LINE:9
def loginWithName : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.messageController.loginWithName",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "loginWithName"})
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
              

// @LINE:20
class ReverseAssets {
    

// @LINE:20
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
        


// @LINE:20
// @LINE:17
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:9
// @LINE:6
package controllers.ref {


// @LINE:17
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
                      

// @LINE:17
def addOneFriend(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.messageController.addOneFriend(), HandlerDef(this, "controllers.messageController", "addOneFriend", Seq(), "POST", """ friends""", _prefix + """addOneFriend""")
)
                      

// @LINE:14
def regiterWithDevice(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.messageController.regiterWithDevice(), HandlerDef(this, "controllers.messageController", "regiterWithDevice", Seq(), "POST", """""", _prefix + """registerDevice""")
)
                      

// @LINE:13
def queryMessages(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.messageController.queryMessages(), HandlerDef(this, "controllers.messageController", "queryMessages", Seq(), "POST", """""", _prefix + """queryMessages""")
)
                      

// @LINE:9
def loginWithName(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.messageController.loginWithName(), HandlerDef(this, "controllers.messageController", "loginWithName", Seq(), "POST", """ login""", _prefix + """loginWithName""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.messageController.index(), HandlerDef(this, "controllers.messageController", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      
    
}
                          

// @LINE:20
class ReverseAssets {
    

// @LINE:20
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          
}
        
    