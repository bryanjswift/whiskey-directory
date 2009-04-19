package com.whiskeydirectory.model

import org.specs.Specification
import org.specs.runner.JUnit4

class LocationTest extends JUnit4(LocationSpecs)

object LocationSpecs extends Specification {
	"CrossStreet must have at least 2 Streets" in {
		try {
			new CrossStreet(List())
			false
		} catch {
			case iae:IllegalArgumentException =>
				true // expected
		}
	}
	"CrossStreet must have fewer than 4 Streets" in {
		try {
			new CrossStreet(List(new NorthSouthStreet("test 1"), new NorthSouthStreet("test 2"),
				new EastWestStreet("test 3"), new EastWestStreet("test 4")))
			false
		} catch {
			case iae:IllegalArgumentException =>
				true // expected
		}
	}
	"CrossStreet may not have all NorthSouthStreets" in {
		try {
			new CrossStreet(List(new NorthSouthStreet("test 1"), new NorthSouthStreet("test 2"), new NorthSouthStreet("test 3")))
			false
		} catch {
			case iae:IllegalArgumentException =>
				true // expected
		}
	}
	"CrossStreet may not have all EastWestStreets" in {
		try {
			new CrossStreet(List(new EastWestStreet("test 1"), new EastWestStreet("test 2"), new EastWestStreet("test 3")))
			false
		} catch {
			case iae:IllegalArgumentException =>
				true // expected
		}
	}
	"CrossStreet may have two or three Streets" in {
		new CrossStreet(List(new NorthSouthStreet("test 1"), new EastWestStreet("test 2")))
		new CrossStreet(List(new NorthSouthStreet("test 1"), new EastWestStreet("test 2"), new NorthSouthStreet("test 3")))
	}
	"Address may not have a null number" in {
		try {
			new Address(null, new EastWestStreet("test 1"), None)
			false
		} catch {
			case iae:IllegalArgumentException =>
				true // expected
		}
	}
	"Address may not have an empty number" in {
		try {
			new Address("", new EastWestStreet("test 1"), None)
			false
		} catch {
			case iae:IllegalArgumentException =>
				true // expected
		}
	}
	"Address may not have a null street" in {
		try {
			new Address("test 1", null, None)
			false
		} catch {
			case iae:IllegalArgumentException =>
				true // expected
		}
	}
}
