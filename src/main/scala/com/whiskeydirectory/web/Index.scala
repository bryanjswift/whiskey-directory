package com.whiskeydirectory.web

import com.whiskeydirectory.model.{Street, NorthSouthStreet, EastWestStreet}
import javax.servlet.http.{HttpServlet, HttpServletRequest => Request, HttpServletResponse => Response}

class Index extends HttpServlet {
	override def doGet(request:Request, response:Response) {
		response.sendRedirect("/index.jsp")
	}
	override def doPost(request:Request, response:Response) {
		val name = request.getParameterValues("name")(0)
		val northVals = request.getParameterValues("longitudinal")
		val street:Street = if (northVals != null && northVals(0) == "true") new NorthSouthStreet(name) else new EastWestStreet(name)
		response.sendRedirect("/index.jsp")
	}
}
