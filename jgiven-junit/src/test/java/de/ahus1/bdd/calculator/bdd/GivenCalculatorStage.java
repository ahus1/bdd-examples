package de.ahus1.bdd.calculator.bdd;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import de.ahus1.bdd.calculator.Calculator;

public class GivenCalculatorStage<SELF extends GivenCalculatorStage<?>> extends Stage<SELF> {

    @ProvidedScenarioState
    Calculator calculator;

    public SELF turned_on() {
        calculator = new Calculator();
        return self();
    }

    public void initialized_with_$_state(long aNumber) {
        calculator.set(aNumber);
    }
}
