package de.ahus1.bdd.calculator;

public class Calculator {
	private long state = 0;

	public void add(long val) {
		state += val;
	}

	public long getState() {
		return state;
	}

	public void set(long val) {
		state = val;
	}

	public void multiplyBy(long val) {
		state *= val;
	}

	public void power(long val) {
		state = new Double(Math.pow(state, val)).longValue();
	}
}
