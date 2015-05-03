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

	def loginWithName = Action (request => requestArgs(request)(messageModule.loginWithName))
	def regiterWithDevice = Action (request => requestArgs(request)(messageModule.regiterWithDevice))
	def sendMessage = Action (request => requestArgs(request)(messageModule.sendMessage))
	def queryMessages = Action (request => requestArgs(request)(messageModule.queryMessages)) 
}