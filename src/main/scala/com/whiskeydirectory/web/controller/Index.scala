package com.whiskeydirectory.web.controller

import javax.servlet.http.{HttpServletRequest => Request}

object Index {
	def render(request:Request) = <p>Rendered from Scala</p>
}
