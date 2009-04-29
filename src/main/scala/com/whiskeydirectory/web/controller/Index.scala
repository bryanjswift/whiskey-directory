package com.whiskeydirectory.web.controller

import com.whiskeydirectory.model.PersistableStreet
import com.whiskeydirectory.persistence.ManagerFactory
import java.util.logging.Logger
import javax.jdo.PersistenceManager
import javax.servlet.http.{HttpServletRequest => Request}

object Index {
	private[this] val logger = Logger.getLogger(classOf[Index].getName);
	def render(request:Request) = <p>Rendered from Scala</p>
	def streets(request:Request):String = {
		val pm = ManagerFactory.manager
		val pstreets = pm.newQuery(classOf[PersistableStreet]).execute.asInstanceOf[List[PersistableStreet]]
		logger.info(pstreets.length + " streets retrieved")
		var out = "<ul>"
		pstreets.foreach(street => out += "<li>" + street.name + "</li>")
		out += "</ul>"
		out
	}
}
