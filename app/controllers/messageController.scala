package controllers

import play.api._
import play.api.mvc._
import module.messageModule._
import controllers.common.requestArgsQuery.requestArgs
import module.messageModule

object messageController extends Controller {
	def index = Action {
		Ok(views.html.index("Your new application is ready."))
	}

	// login
	def loginWithName = Action (request => requestArgs(request)(messageModule.loginWithName))

	// friends
	def addOneFriend = Action (request => requestArgs(request)(messageModule.addOneFriend))
	def deleteOneFriend = Action (request => requestArgs(request)(messageModule.deleteOneFriend)) 
	def queryAllFriend = Action (request => requestArgs(request)(messageModule.queryFriends)) 
	
	// message
	def regiterWithDevice = Action (request => requestArgs(request)(messageModule.regiterWithDevice))
	def sendMessage = Action (request => requestArgs(request)(messageModule.sendMessage))
	def queryMessages = Action (request => requestArgs(request)(messageModule.queryMessages)) 
	def queryMessagesWithFriend = Action (request => requestArgs(request)(messageModule.queryMessageWithFriend)) 
}