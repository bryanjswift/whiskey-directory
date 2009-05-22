package com.whiskeydirectory.model

import com.whiskeydirectory.persistence.{Savable,Tabled}

sealed abstract class Street(val name:String) extends Savable {
	require(name != null && name != "")
	def longitudinal:Boolean
	def latitudinal:Boolean
	override val table = "`whiskeydirectory`.`street`"
	override val fields = List("name","longitudinal","latitudinal")
	override def values:List[String] =
		List(name.mkString("'","","'"),binary(longitudinal),binary(latitudinal))
}

case class NorthSouthStreet(override val name:String) extends Street(name) {
	override val longitudinal = true
	override val latitudinal = false
}

case class EastWestStreet(override val name:String) extends Street(name) {
	override val longitudinal = false
	override val latitudinal = true
}