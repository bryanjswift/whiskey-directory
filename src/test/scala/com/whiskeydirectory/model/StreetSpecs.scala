package com.whiskeydirectory.model

import org.specs.Specification
import org.specs.runner.JUnit4

class StreetTest extends JUnit4(StreetSpecs)

object StreetSpecs extends Specification {
	"null Street name should throw exception" in {
		try {
			val street = new Street(null, true, false)
			false // exception should be thrown
		} catch {
			case iae:IllegalArgumentException =>
				true // expected
		}
	}
	"empty Street name should throw exception" in {
		try {
			val street = new Street("", true, false)
			false // exception should be thrown
		} catch {
			case iae:IllegalArgumentException =>
				true // expected
		}
	}
	"either longitudinal and latitudinal must be true" in {
		try {
			val street = new Street("Houston", false, false)
			false // exception should be thrown
		} catch {
			case iae:IllegalArgumentException =>
				true // expected
		}
	}
	"either longitudinal and latitudinal must be false" in {
		try {
			val street = new Street("Houston", true, true)
			false // exception should be thrown
		} catch {
			case iae:IllegalArgumentException =>
				true // expected
		}
	}
}
