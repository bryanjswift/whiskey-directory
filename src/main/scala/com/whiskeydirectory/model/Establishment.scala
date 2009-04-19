package com.whiskeydirectory.model

class Establishment(val name:String, val neighborhood:Option[String], val location:Option[Location]) {
	require(name != null && name != "")
}
