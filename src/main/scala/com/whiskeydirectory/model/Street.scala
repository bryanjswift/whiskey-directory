package com.whiskeydirectory.model

import com.whiskeydirectory.persistence.{Savable,Tabled}

abstract class Street(val name:String) extends Savable {
	require(name != null && name != "")
	def longitudinal:Boolean
	def latitudinal:Boolean
	def insert:String =
		"INSERT INTO " + Street.table + Street.fields.mkString(" (`","`, `","`) ") + "VALUES" + values.mkString(" (",", ",");")
	def values:List[String] =
		List("NULL",name.mkString("'","","'"),binary(longitudinal),binary(latitudinal))
}

case class NorthSouthStreet(override val name:String) extends Street(name) {
	override val longitudinal = true
	override val latitudinal = false
}

case class EastWestStreet(override val name:String) extends Street(name) {
	override val longitudinal = false
	override val latitudinal = true
}

object Street extends Tabled {
	val table = "`whiskeydirectory`.`street`"
	val fields = List("id","name","longitudinal","latitudinal")
}
