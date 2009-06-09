package com.whiskeydirectory.model

import com.bryanjswift.persistence.annotations.{Entity,Persistent,PersistentEntity}
import com.whiskeydirectory.persistence.Savable

class Establishment(
	@Persistent val name:String,
	@Persistent val neighborhood:Option[String],
	@PersistentEntity val location:Option[Location])
		extends Savable {

	var id:Long = _
	require(name != null && name != "")
}
