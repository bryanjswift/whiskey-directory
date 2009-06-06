package com.whiskeydirectory.persistence.datastore

import com.google.appengine.api.datastore.{DatastoreService,DatastoreServiceFactory,Entity}
import com.whiskeydirectory.persistence.{Persister,Savable}
import java.io.Serializable

object DatastorePersister extends Persister {
	val datastore = DatastoreServiceFactory.getDatastoreService()
	def save(obj:Savable):Serializable = {
		val entity = new Entity(obj.getClass().getSimpleName(),obj.id.toString)
		val map = obj.fields zip obj.values
		map.foreach(t => {
			entity.setProperty(t._1,t._2)
		})
		datastore.put(entity)
	}
}