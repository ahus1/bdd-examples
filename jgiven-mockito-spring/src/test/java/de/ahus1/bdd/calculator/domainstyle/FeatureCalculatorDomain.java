package de.ahus1.bdd.calculator.domainstyle;

import com.tngtech.jgiven.junit.ScenarioTest;
import de.ahus1.bdd.calculator.domainstyle.bdd.GivenCalculatorDomainStage;
import de.ahus1.bdd.calculator.domainstyle.bdd.ThenCalculatorDomainOutcome;
import de.ahus1.bdd.calculator.domainstyle.bdd.WhenCalculatorDomainAction;
import de.ahus1.bdd.calculator.categories.FastTest;
import de.ahus1.bdd.calculator.common.Story;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Story("To avoid stupid calculation errors I use a calculator")
@Category(FastTest.class)
public class FeatureCalculatorDomain extends ScenarioTest<GivenCalculatorDomainStage<?>,
        WhenCalculatorDomainAction<?>, ThenCalculatorDomainOutcome<?>> {

    @Test
    public void should_cope_with_additions() {
        given().with_an_initial_state();
        when().adds(4).and().adds(5);
        then().shows(9);
    }

}
