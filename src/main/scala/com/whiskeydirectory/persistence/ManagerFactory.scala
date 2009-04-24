package com.whiskeydirectory.persistence

import javax.jdo.JDOHelper
import javax.jdo.PersistenceManager
import javax.jdo.PersistenceManagerFactory

object ManagerFactory {
	private val instance = JDOHelper.getPersistenceManagerFactory("transactions-optional")
	def apply():PersistenceManagerFactory = instance
	def manager():PersistenceManager = instance.getPersistenceManager()
}
