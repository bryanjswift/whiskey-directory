package com.whiskeydirectory.model

abstract class Street(val name:String) {
	require(name != null && name != "")
	def longitudinal:Boolean
	def latitudinal:Boolean
}

case class NorthSouthStreet(override val name:String) extends Street(name) {
	override val longitudinal = true
	override val latitudinal = false
}

case class EastWestStreet(override val name:String) extends Street(name) {
	override val longitudinal = false
	override val latitudinal = true
}
