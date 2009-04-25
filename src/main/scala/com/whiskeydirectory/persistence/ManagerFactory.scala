package com.whiskeydirectory.persistence

import javax.jdo.{JDOHelper, PersistenceManager, PersistenceManagerFactory}

object ManagerFactory {
	private val instance = JDOHelper.getPersistenceManagerFactory("transactional")
	def apply():PersistenceManagerFactory = instance
	def manager():PersistenceManager = instance.getPersistenceManager()
}
