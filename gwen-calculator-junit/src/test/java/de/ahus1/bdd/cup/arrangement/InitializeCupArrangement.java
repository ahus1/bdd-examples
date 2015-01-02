package de.ahus1.bdd.cup.arrangement;

import com.shazam.gwen.tasks.Arrangement;

import de.ahus1.bdd.calculator.Cup;

public class InitializeCupArrangement implements Arrangement<Cup> {

	private long val;

	public InitializeCupArrangement(long val) {
		this.val = val;
	}

	public void arrangeWith(Cup cup) {
		cup.refill(val);
	}
}
