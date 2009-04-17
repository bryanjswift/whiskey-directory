package com.whiskeydirectory.model

class Drink(val name:String, val tags:Map[String,Int], val location:Option[Location]) {
	def this(name:String) = this(name, Map(), None)
	def this(name:String, tags:Map[String,Int]) = this(name, tags, None)

	def add(tag:String) {
		val ntags = if (tags contains tag)
				tags ++ Map(tag -> (tags(tag) + 1))
			else
				tags ++ Map(tag -> 1)
		new Drink(name, ntags, location)
	}

	def change(location:Location) = new Drink(name, ntags, location)
}
