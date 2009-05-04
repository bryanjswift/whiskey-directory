package com.whiskeydirectory.persistence

// probably these methods could be implemented concretely and made to read from a class path resource of the same name as the companion class rather than requiring definition in a sub-object
trait Tabled {
	val table:String
	val fields:List[String]
}
