package com.whiskeydirectory.model

import com.bryanjswift.persistence.annotations.{Entity,Persist}
import com.whiskeydirectory.persistence.Savable

@Entity{val name="Street"}
sealed abstract class Street(@Persist val name:String) extends Savable {
	require(name != null && name != "")
	@Persist
	def longitudinal:Boolean
	@Persist
	def latitudinal:Boolean
	@Persist
	override val id = name.hashCode.toLong
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