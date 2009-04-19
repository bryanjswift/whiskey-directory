package com.whiskeydirectory.model

import org.specs.Specification
import org.specs.runner.JUnit4

class LocationTest extends JUnit4(LocationSpecs)

object LocationSpecs extends Specification {
	"CrossStreet must have at least 2 streets" in {
		try {
			new CrossStreet(List())
			false
		} catch {
			case iae:IllegalArgumentException =>
				true // expected
		}
	}
	"CrossStreet must have fewer than 4 streets" in {
		try {
			new CrossStreet(List(new NorthSouthStreet("test 1"), new NorthSouthStreet("test 2"),
				new EastWestStreet("test 3"), new EastWestStreet("test 4")))
			false
		} catch {
			case iae:IllegalArgumentException =>
				true // expected
		}
	}
}
