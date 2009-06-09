package com.whiskeydirectory.model

import com.bryanjswift.persistence.annotations.{Entity,Persistent}
import com.whiskeydirectory.persistence.Savable

@Entity{val name = "Street"}
sealed abstract class Street(@Persistent val name:String) extends Savable {
	require(name != null && name != "")
	@Persistent def longitudinal:Boolean
	@Persistent def latitudinal:Boolean
	override val id = name.hashCode.toLong
}

case class NorthSouthStreet(override val name:String) extends Street(name) {
	override val longitudinal = true
	override val latitudinal = false
}

case class EastWestStreet(override val name:String) extends Street(name) {
	override val longitudinal = false
	override val latitudinal = true
}
