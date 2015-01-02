package de.ahus1.bdd.cup.arrangement;

import com.shazam.gwen.tasks.Arrangement;

import de.ahus1.bdd.calculator.Cup;

public abstract class CupArrangements {

	public static Arrangement<Cup> initialize(long val) {
		return new InitializeCupArrangement(val);
	}
}
