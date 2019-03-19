package de.ahus1.bdd.calculator.bdd;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import de.ahus1.bdd.calculator.Calculator;

import java.util.List;

public class WhenCalculatorAction<SELF extends WhenCalculatorAction<?>> extends Stage<SELF> {

    @ExpectedScenarioState
    Calculator calculator;

    public SELF adds(long aNumber) {
        calculator.add(aNumber);
        return self();
    }

    public SELF multiplies_by(long aNumber) {
        calculator.multiplyBy(aNumber);
        return self();
    }

    public SELF powerBy(long aNumber) {
        calculator.power(aNumber);
        return self();
    }
}
