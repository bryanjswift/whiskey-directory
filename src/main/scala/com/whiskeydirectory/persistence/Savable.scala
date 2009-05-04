package com.whiskeydirectory.persistence

// these methods could probably be implemented using reflection
trait Savable {
	def insert():String
	def statement():String
	def update():String
	def values():List[String]
	def binary(b:Boolean):String = if (b) "'1'" else "'0'"
}
