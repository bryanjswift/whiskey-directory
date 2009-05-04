package com.whiskeydirectory.persistence

trait Savable {
	def insert():String
	def values():List[String]
	def binary(b:Boolean):String = if (b) "'1'" else "'0'"
}
