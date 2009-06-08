package com.whiskeydirectory.persistence

import com.bryanjswift.persistence.annotations.{Entity,Persistent,PersistentEntity}

trait Savable {
	def id:Long
	lazy val table:String = getEntityName(this.getClass())
	lazy val fields:List[String] = {
		for {
			method <- getMethods(this.getClass())
			if method.getAnnotation(classOf[Persistent]) != null
		} yield method.getName()
	}
	lazy val values:List[Any] = {
		val c = this.getClass()
		for {
			field <- fields
		} yield c.getDeclaredMethod(field).invoke(this)
	}
	lazy val entities:List[Savable] = {
		for {
			method <- getMethods(this.getClass())
			if (method.getAnnotation(classOf[PersistentEntity]) != null)
		} yield method.invoke(this).asInstanceOf[Savable]
	}
	private def getEntityName(c:Class[_]):String = {
		val entity = c.getAnnotation(classOf[Entity])
		if (entity == null && c.getSuperclass() != null)
			getEntityName(c.getSuperclass())
		else if (entity == null && c.getSuperclass() == null)
			"Default"
		else
			entity.name()
	}
	private def getMethods(c:Class[_]):List[java.lang.reflect.Method] = {
		if (c.getSuperclass() != null)
			getMethods(c.getSuperclass()) ::: c.getDeclaredMethods().toList
		else
			c.getDeclaredMethods().toList
	}
}
