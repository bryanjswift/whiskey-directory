package com.whiskeydirectory.model

import com.bryanjswift.persistence.annotations.{Entity,Persistent,PersistentEntity}
import com.whiskeydirectory.persistence.Savable

@Entity{val name = "Drink"}
class Drink(
	@Persistent val name:String,
	@Persistent val tags:Option[List[String]],
	@PersistentEntity val establishment:Option[Establishment])
		extends Savable {

	require(name != null && name.length > 0)
	def this(name:String) = this(name, None, None)
	def this(name:String, tags:List[String]) = this(name, Some(tags), None)

	var id:Long = _
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
