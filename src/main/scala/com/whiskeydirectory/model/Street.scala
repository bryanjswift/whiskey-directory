package com.whiskeydirectory.model

import com.whiskeydirectory.persistence.{Persistable,Savable}

abstract class Street(val name:String) {
	require(name != null && name != "")
	def longitudinal:Boolean
	def latitudinal:Boolean

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
