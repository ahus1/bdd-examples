package de.ahus1.bdd.calculator.domainstyle.bdd;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import de.ahus1.bdd.calculator.application.CalculatorApplication;

public class WhenCalculatorDomainAction<SELF extends WhenCalculatorDomainAction<?>> extends Stage<SELF> {

    @ExpectedScenarioState
    private CalculatorApplication calculatorApplication;

    public SELF adds(long aNumber) {
        calculatorApplication.add(aNumber);
        return self();
    }

}
