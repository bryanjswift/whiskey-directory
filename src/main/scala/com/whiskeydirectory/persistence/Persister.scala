package com.whiskeydirectory.persistence

trait Persister {
	def save(obj:Savable):Unit
}
