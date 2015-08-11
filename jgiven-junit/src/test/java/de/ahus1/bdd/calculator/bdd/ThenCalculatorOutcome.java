package de.ahus1.bdd.calculator.bdd;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import de.ahus1.bdd.calculator.Calculator;
import org.assertj.core.api.Assertions;

public class ThenCalculatorOutcome<SELF extends ThenCalculatorOutcome<?>> extends Stage<SELF> {

    @ExpectedScenarioState
    Calculator calculator;

    public SELF shows(long aNumber) {
        Assertions.assertThat(calculator.getState()).isEqualTo(aNumber);
        return self();
    }

}
