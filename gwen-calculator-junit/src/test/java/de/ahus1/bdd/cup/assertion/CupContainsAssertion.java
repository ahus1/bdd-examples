package de.ahus1.bdd.cup.assertion;

import static org.fest.assertions.Assertions.assertThat;

import com.shazam.gwen.tasks.Assertion;

import de.ahus1.bdd.calculator.Cup;

public class CupContainsAssertion implements Assertion<Cup> {

	private long val;

	public CupContainsAssertion(long val) {
		this.val = val;
	}

	public void assertWith(Cup cup) {
		assertThat(cup.getState()).isEqualTo(val);
	}
}
