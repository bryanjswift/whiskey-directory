package com.whiskeydirectory.persistence.mysql

import com.whiskeydirectory.persistence.{Persister,Savable}

object MysqlPersister extends Persister {
	def save(obj:Savable):Unit = {
		val statement = if (obj.id > 0) update(obj) else insert(obj)
		return
	}
	private def insert(obj:Savable):String =
		"INSERT INTO " + obj.table + obj.fields.mkString(" (`","`, `","`) ") + "VALUES" + obj.values.mkString(" (",", ",");")
	private def update(obj:Savable):String =
		"UPDATE " + obj.table + obj.fields.tail.mkString(" (`","`, `","`) ") + "VALUES" + obj.values.tail.mkString(" (",", ",")") + " WHERE id = " + obj.id + ";"
}
