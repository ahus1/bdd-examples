package de.ahus1.bdd.calculator.domainstyle.bdd;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import de.ahus1.bdd.calculator.application.CalculatorApplication;
import org.assertj.core.api.Assertions;

public class ThenCalculatorDomainOutcome<SELF extends ThenCalculatorDomainOutcome<?>> extends Stage<SELF> {

    @ExpectedScenarioState
    private CalculatorApplication calculatorApplication;

    public SELF shows(long aNumber) {
        Assertions.assertThat(calculatorApplication.getState().getState()).isEqualTo(aNumber);
        return self();
    }

}
