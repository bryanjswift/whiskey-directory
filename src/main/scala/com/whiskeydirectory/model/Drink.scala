package com.whiskeydirectory.model

class Drink(val name:String, val tags:Map[String,Int], val location:Option[Location]) {
	def this(name:String) = this(name, Map(), None)
	def this(name:String, tags:Map[String,Int]) = this(name, tags, None)

	def add(tag:String) {
		val ntags = if (tags contains tag) tags ++ Map(tag -> (tags(tag) + 1)) else tags ++ Map(tag -> 1)
		Drink(name, ntags, location)
	}
	def apply(tag:String) = this add tag
	def apply(location:Location) = this change location
	def change(location:Location) = Drink(name, tags, Some(location))
}

object Drink {
	def apply(name:String, tags:Map[String,Int], location:Option[Location]) = new Drink(name, tags, location)
}
