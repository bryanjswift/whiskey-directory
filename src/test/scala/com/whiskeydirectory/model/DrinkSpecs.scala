package com.whiskeydirectory.model

import org.specs.Specification
import org.specs.runner.JUnit4

class DrinkTest extends JUnit4(DrinkSpecs)

object DrinkSpecs extends Specification {
	"null Drink name should throw exception" in {
		try {
			val drink = new Drink(null)
			false // exception should be thrown
		} catch {
			case iae:IllegalArgumentException =>
				true // expected
		}
	}
	"empty Drink name should throw exception" in {
		try {
			val drink = new Drink("")
			false // exception should be thrown
		} catch {
			case iae:IllegalArgumentException =>
				true // expected
		}
	}
}
