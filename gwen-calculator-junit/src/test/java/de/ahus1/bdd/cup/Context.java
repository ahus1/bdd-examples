package de.ahus1.bdd.cup;

import com.shazam.gwen.tasks.Action;

import com.shazam.gwen.tasks.Arrangement;
import com.shazam.gwen.tasks.Assertion;
import de.ahus1.bdd.calculator.Cup;

public class Context {

	private Cup cup;

	public void setCup(Cup cup) {
		this.cup = cup;
	}

	public <T> T cup(Action<Cup, T> action) {
		return action.actOn(cup);
	}

	public void cup(Assertion<Cup> assertion) {
		assertion.assertWith(cup);
	}

	public void cup(Arrangement<Cup> arrangement) {
		arrangement.arrangeWith(cup);
	}

}
