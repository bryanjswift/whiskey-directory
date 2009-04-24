package com.whiskeydirectory.model

import com.whiskeydirectory.persistence.{Persistable,Savable}
import javax.jdo.annotations._

class Drink(val name:String, val tags:Option[List[String]], val establishment:Option[Establishment]) extends Savable {
	require(name != null && name.length > 0)
	def this(name:String) = this(name, None, None)
	def this(name:String, tags:List[String]) = this(name, Some(tags), None)

	def getPersistable():Persistable = {
		val drink = new PersistableDrink()
		drink.name = name
		drink.tags = tags match {
			case Some(t) => t
			case None => List[String]()
		}
		drink.establishment = establishment match {
			case Some(e) => e
			case None => null
		}
		drink
	}

	@PersistenceCapable { val identityType = IdentityType.APPLICATION }
	class PersistableDrink extends Persistable {
		@PrimaryKey
		@Persistent { val valueStrategy = IdGeneratorStrategy.IDENTITY }
		var id = 0
		@Persistent
		var name = ""
		@Persistent
		var tags = List[String]()
		@Persistent
		var establishment:Establishment = null
	}
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
