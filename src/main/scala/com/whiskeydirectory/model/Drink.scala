package com.whiskeydirectory.model

class Drink(val name:String, val tags:Option[List[String]], val location:Option[Location]) {
	def this(name:String) = this(name, Map(), None)
	def this(name:String, tags:Map[String,Int]) = this(name, tags, None)
}

object Drink {
	def apply(name:String, tags:Option[List[String]], location:Option[Location]) = new Drink(name, tags, location)
}
