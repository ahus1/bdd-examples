package de.ahus1.bdd.cup.assertion;

import com.shazam.gwen.tasks.Assertion;

import de.ahus1.bdd.calculator.Cup;

public abstract class CupAssertions {

	public static Assertion<Cup> isFilledWith(long val) {
		return new CupContainsAssertion(val);
	}
}
