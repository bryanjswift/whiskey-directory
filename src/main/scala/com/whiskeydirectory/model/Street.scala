package com.whiskeydirectory.model

import com.whiskeydirectory.persistence.{Persistable,Savable}
import javax.jdo.annotations._

abstract class Street(val name:String) extends Savable {
	require(name != null && name != "")
	def longitudinal:Boolean
	def latitudinal:Boolean

	def getPersistable():Persistable = {
		val street = new PersistableStreet()
		street.name = name
		street.latitudinal = latitudinal
		street.longitudinal = longitudinal
		street
	}

	@PersistenceCapable { val identityType = IdentityType.APPLICATION }
	class PersistableStreet extends Persistable {
		@PrimaryKey
		@Persistent { val valueStrategy = IdGeneratorStrategy.IDENTITY }
		var id = 0
		@Persistent
		var name = ""
		@Persistent
		var longitudinal = false
		@Persistent
		var latitudinal = false
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
