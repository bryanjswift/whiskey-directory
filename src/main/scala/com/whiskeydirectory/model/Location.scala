package com.whiskeydirectory.model

import com.bryanjswift.persistence.annotations.{Entity,Persistent,PersistentEntity}
import com.whiskeydirectory.persistence.Savable

abstract class Location

@Entity{val name = "CrossStreet"}
case class CrossStreet(@PersistentEntity val streets:List[Street]) extends Savable {
	var id:Long = _
	val streetsLength = streets.length
	require(streetsLength == 2 || streetsLength == 3)
	require(streets.filter(street => street.longitudinal).length >= 1)
	require(streets.filter(street => street.latitudinal).length >= 1)
}

case class Address(val number:String, val street:Street, val description:Option[String]) {
	require(number != null && number != "")
	require(street != null)
}
