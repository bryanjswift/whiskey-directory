package com.whiskeydirectory.persistence

// these methods could probably be implemented using reflection
trait Savable {
	var id:Long = _
	val table:String
	val fields:List[String]
	/* I want this function to be able to derive what fields should be included here */
	def values:List[String]
	def binary(b:Boolean):String = if (b) "'1'" else "'0'"
}
