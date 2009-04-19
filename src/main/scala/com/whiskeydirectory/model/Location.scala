package com.whiskeydirectory.model

abstract class Location

case class CrossStreet(val streets:List[Street]) {
	val streetsLength = streets.length
	require(streetsLength == 2 || streetsLength == 3)
	require(streets.filter(street => street.longitudinal).length >= 1)
	require(streets.filter(street => street.latitudinal).length >= 1)
}

case class Address(val number:String, val street:Street, val description:String) {
	require(number != null && number != "")
	require(street != null)
}
