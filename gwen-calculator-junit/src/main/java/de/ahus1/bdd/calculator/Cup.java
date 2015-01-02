package de.ahus1.bdd.calculator;

public class Cup {
	private long state = 0;

	public void refill(long val) {
		state += val;
	}

	public void drink(long val) {
		state -= val;
	}

	public long getState() {
		return state;
	}
}
