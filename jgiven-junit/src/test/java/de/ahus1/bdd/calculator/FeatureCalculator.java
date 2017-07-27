package de.ahus1.bdd.calculator;

import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.junit.ScenarioTest;
import de.ahus1.bdd.calculator.bdd.GivenCalculatorStage;
import de.ahus1.bdd.calculator.bdd.ThenCalculatorOutcome;
import de.ahus1.bdd.calculator.bdd.WhenCalculatorAction;
import de.ahus1.bdd.calculator.common.Story;
import org.junit.Test;

@Story("To avoid stupid calculation errors I use a calculator")
public class FeatureCalculator extends ScenarioTest<GivenCalculatorStage<?>,
        WhenCalculatorAction<?>, ThenCalculatorOutcome<?>> {

    @Test
    public void should_cope_with_additions() {
        given().turned_on();
        when().adds(4).and().adds(5);
        then().shows(9);
    }

    @Test
    public void should_cope_with_multiplications() {
        given().turned_on().and().initialized_with_$_state(2);
        when().multiplies_by(2);
        then().shows(4);
    }

    @Test
    public void should_cope_with_exponentials() {
        given().turned_on().and().initialized_with_$_state(4);
        when().powerBy(2);
        then().shows(16);
    }

    @Test
    @Pending("do this later")
    public void should_cope_with_sinus_calculations() {
    }

}
