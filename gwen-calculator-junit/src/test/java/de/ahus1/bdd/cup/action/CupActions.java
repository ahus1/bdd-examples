package de.ahus1.bdd.cup.action;

import com.shazam.gwen.tasks.Action;

import de.ahus1.bdd.calculator.Cup;

public abstract class CupActions {

	public static Action<Cup, Void> drink(long val) {
		return (cup) -> {
			cup.drink(val);
			return null;
		};
	}
}
