package com.whiskeydirectory.persistence

trait Tabled {
	val table:String
	val fields:List[String]
}
