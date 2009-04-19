package com.whiskeydirectory.model

class Street(val name:String, val longitudinal:Boolean, val latitudinal:Boolean) {
	require(name != null && name != "")
	require(!(longitudinal && latitudinal))
}
