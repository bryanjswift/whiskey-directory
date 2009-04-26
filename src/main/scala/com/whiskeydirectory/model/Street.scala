package com.whiskeydirectory.model

import com.whiskeydirectory.persistence.{Persistable,Savable}
import javax.jdo.annotations._

abstract class Street(val name:String) {
	def longitudinal:Boolean
	def latitudinal:Boolean

	def getPersistable():PersistableStreet = {
		new PersistableStreet(name,longitudinal,latitudinal)
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

@PersistenceCapable { val identityType = IdentityType.APPLICATION }
class PersistableStreet(
		@Persistent var name:String,
		@Persistent var longitudinal:Boolean,
		@Persistent var latitudinal:Boolean) {
	def this() = this("", false, false)
	@PrimaryKey
	@Persistent { val valueStrategy = IdGeneratorStrategy.IDENTITY }
	var id:java.lang.Long = _

	def street():Street = if (longitudinal) new NorthSouthStreet(name) else new EastWestStreet(name)
}

