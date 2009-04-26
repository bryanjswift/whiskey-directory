package com.whiskeydirectory.model

import com.whiskeydirectory.persistence.{Persistable,Savable}
import javax.jdo.annotations._

abstract class Street(val name:String) {
	require(name != null && name != "")
	def longitudinal:Boolean
	def latitudinal:Boolean

/*
	def getPersistable():PersistableStreet = {
		new PersistableStreet(name,longitudinal,latitudinal)
	}
*/

	def getPersistable():PersistableStreet = {
		val street = new PersistableStreet()
		street.setName(name)
		street.setLatitudinal(latitudinal)
		street.setLongitudinal(longitudinal)
		street
	}
}

case class NorthSouthStreet(override val name:String) extends Street(name) {
	override val longitudinal = true
	override val latitudinal = false
}

case class EastWestStreet(override val name:String) extends Street(name) {
	override val longitudinal = false
	override val latitudinal = true
}

/*
@PersistenceCapable { val identityType = IdentityType.APPLICATION }
class PersistableStreet(
		@Persistent override val name:String,
		@Persistent override val longitudinal:Boolean,
		@Persistent override val latitudinal:Boolean) extends Street(name) {
	def this() = this("", false, false)
	@PrimaryKey
	@Persistent { val valueStrategy = IdGeneratorStrategy.IDENTITY }
	var id:Long = 0
}
*/
