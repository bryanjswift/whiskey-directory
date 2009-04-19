package com.whiskeydirectory.model

class Establishment(val name:String, val neighborhood:String, val location:Location) {
	require(name != null && name != "")
}
