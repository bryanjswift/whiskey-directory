package com.whiskeydirectory.persistence

trait Savable {
	def getPersistable():Persistable
}

trait Persistable { }
