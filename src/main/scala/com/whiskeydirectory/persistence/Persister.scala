package com.whiskeydirectory.persistence

import java.io.Serializable

trait Persister {
	def save(obj:Savable):Serializable
}
