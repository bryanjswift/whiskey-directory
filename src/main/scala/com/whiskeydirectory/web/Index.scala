package com.whiskeydirectory.web

import com.whiskeydirectory.model.{Street, NorthSouthStreet, EastWestStreet}
import com.whiskeydirectory.persistence.ManagerFactory
import javax.jdo.PersistenceManager
import javax.servlet.http.{HttpServlet, HttpServletRequest => Request, HttpServletResponse => Response}

class Index extends HttpServlet {
	override def doGet(request:Request, response:Response) {
		response.sendRedirect("/index.jsp")
	}
	override def doPost(request:Request, response:Response) {
		val name = request.getParameterValues("name")(0)
		val northVals = request.getParameterValues("longitudinal")
		val street:Street = if (northVals != null && northVals(0) == "true") new NorthSouthStreet(name) else new EastWestStreet(name)
		val pm = ManagerFactory.manager
		try {
			pm.makePersistent(street.getPersistable)
		} finally {
			pm.close
		}
		response.sendRedirect("/index.jsp")
	}
}
