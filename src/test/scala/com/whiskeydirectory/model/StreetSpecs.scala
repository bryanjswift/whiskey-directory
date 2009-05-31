package com.whiskeydirectory.model

import org.specs.Specification
import org.specs.runner.JUnit4

class StreetTest extends JUnit4(StreetSpecs)

object StreetSpecs extends Specification {
	def have = addToSusVerb("have")
	"null Street name should throw exception" in {
		try {
			val street = new NorthSouthStreet(null)
			false // exception should be thrown
		} catch {
			case e:Exception =>
				e must haveClass[IllegalArgumentException]
		}
	}
	"empty Street name should throw exception" in {
		try {
			val street = new EastWestStreet("")
			false // exception should be thrown
		} catch {
			case e:Exception =>
				e must haveClass[IllegalArgumentException]
		}
	}
	"NorthSouthStreet('6th Ave')" should have {
		val street = new NorthSouthStreet("6th Ave")
		"values of List('6th Ave','1','0')" in {
			street.values must_== List("'6th Ave'","'1'","'0'")
		}
	}
}
