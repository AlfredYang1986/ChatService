// @SOURCE:/Users/yangyuan/Desktop/ChatService2/conf/routes
// @HASH:3f58788c03b1ff5bada86d7bbe33ccd17d838f16
// @DATE:Mon May 04 00:53:43 HKT 2015

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString


// @LINE:14
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:6
package controllers {

// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:6
class ReversemessageController {
    

// @LINE:9
def sendMessage(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "sendMessage")
}
                                                

// @LINE:11
def regiterWithDevice(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "registerDevice")
}
                                                

// @LINE:10
def queryMessages(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "queryMessages")
}
                                                

// @LINE:8
def loginWithName(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "loginWithName")
}
                                                

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                
    
}
                          

// @LINE:14
class ReverseAssets {
    

// @LINE:14
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          
}
                  


// @LINE:14
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:6
package controllers.javascript {

// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:6
class ReversemessageController {
    

// @LINE:9
def sendMessage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.messageController.sendMessage",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "sendMessage"})
      }
   """
)
                        

// @LINE:11
def regiterWithDevice : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.messageController.regiterWithDevice",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "registerDevice"})
      }
   """
)
                        

// @LINE:10
def queryMessages : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.messageController.queryMessages",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "queryMessages"})
      }
   """
)
                        

// @LINE:8
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
              

// @LINE:14
class ReverseAssets {
    

// @LINE:14
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
        


// @LINE:14
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:6
package controllers.ref {


// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:6
class ReversemessageController {
    

// @LINE:9
def sendMessage(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.messageController.sendMessage(), HandlerDef(this, "controllers.messageController", "sendMessage", Seq(), "POST", """""", _prefix + """sendMessage""")
)
                      

// @LINE:11
def regiterWithDevice(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.messageController.regiterWithDevice(), HandlerDef(this, "controllers.messageController", "regiterWithDevice", Seq(), "POST", """""", _prefix + """registerDevice""")
)
                      

// @LINE:10
def queryMessages(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.messageController.queryMessages(), HandlerDef(this, "controllers.messageController", "queryMessages", Seq(), "POST", """""", _prefix + """queryMessages""")
)
                      

// @LINE:8
def loginWithName(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.messageController.loginWithName(), HandlerDef(this, "controllers.messageController", "loginWithName", Seq(), "POST", """""", _prefix + """loginWithName""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.messageController.index(), HandlerDef(this, "controllers.messageController", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      
    
}
                          

// @LINE:14
class ReverseAssets {
    

// @LINE:14
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          
}
        
    