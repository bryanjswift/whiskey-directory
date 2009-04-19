package com.whiskeydirectory.model

import org.specs.Specification
import org.specs.runner.JUnit4

class EstablishmentTest extends JUnit4(EstablishmentSpecs)

object EstablishmentSpecs extends Specification {
	"null Establishment name should throw exception" in {
		try {
			val establishment = new Establishment(null, None, None)
			false // exception should be thrown
		} catch {
			case iae:IllegalArgumentException =>
				true // expected
		}
	}
	"empty Establishment name should throw exception" in {
		try {
			val establishment = new Establishment("", None, None)
			false // exception should be thrown
		} catch {
			case iae:IllegalArgumentException =>
				true // expected
		}
	}
}
