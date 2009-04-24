package com.whiskeydirectory.web

import javax.servlet.http.{HttpServlet, HttpServletRequest => Request, HttpServletResponse => Response}

class Index extends HttpServlet {
	override def doGet(request:Request, response:Response) {
		response.setContentType("text/plain")
		response.getWriter.println("Hello, Scala world")
	}
}
