package com.whiskeydirectory.model

import org.specs.Specification
import org.specs.runner.JUnit4

class StreetTest extends JUnit4(StreetSpecs)

object StreetSpecs extends Specification {
	"null Street name should throw exception" in {
		try {
			val street = new NorthSouthStreet(null)
			false // exception should be thrown
		} catch {
			case iae:IllegalArgumentException =>
				true // expected
		}
	}
	"empty Street name should throw exception" in {
		try {
			val street = new EastWestStreet("")
			false // exception should be thrown
		} catch {
			case iae:IllegalArgumentException =>
				true // expected
		}
	}
}
