package com.whiskeydirectory.persistence

import com.bryanjswift.persistence.annotations.{Entity}

// these methods could probably be implemented using reflection
trait Savable {
	def id:Long
	def table:String = getEntityName(this.getClass())
	val fields:List[String]
	/* I want this function to be able to derive what fields should be included here */
	def values:List[String]
	private def getEntityName(c:Class[_]):String = {
		val entity = c.getAnnotation(classOf[Entity])
		if (entity == null && c.getSuperclass() != null)
			getEntityName(c.getSuperclass())
		else if (entity == null && c.getSuperclass() == null)
			"Default"
		else
			entity.name()
	}
	def binary(b:Boolean):String = if (b) "'1'" else "'0'"
}
