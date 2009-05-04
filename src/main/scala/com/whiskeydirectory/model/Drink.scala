package com.whiskeydirectory.model

import com.whiskeydirectory.persistence.{Persistable,Savable}

class Drink(val name:String, val tags:Option[List[String]], val establishment:Option[Establishment]) {
	require(name != null && name.length > 0)
	def this(name:String) = this(name, None, None)
	def this(name:String, tags:List[String]) = this(name, Some(tags), None)
}

object Drink {
	def apply(name:String, tags:List[String], establishment:Establishment) {
		if (tags == null && establishment == null)
			new Drink(name, None, None)
		else if (tags == null)
			new Drink(name, None, Some(establishment))
		else if (establishment == null)
			new Drink(name, Some(tags), None)
		else
			new Drink(name, Some(tags), Some(establishment))
	}
}
