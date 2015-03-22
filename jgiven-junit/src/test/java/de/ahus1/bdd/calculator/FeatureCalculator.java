package de.ahus1.bdd.calculator;

import com.tngtech.jgiven.annotation.NotImplementedYet;
import com.tngtech.jgiven.junit.ScenarioTest;
import de.ahus1.bdd.calculator.bdd.GivenCalculatorStage;
import de.ahus1.bdd.calculator.bdd.ThenCalculatorOutcome;
import de.ahus1.bdd.calculator.bdd.WhenCalculatorAction;
import de.ahus1.bdd.calculator.common.Story;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Test;

@Story("To avoid stupid calculation errors I use a calculator")
public class FeatureCalculator extends ScenarioTest<GivenCalculatorStage<?>,
        WhenCalculatorAction<?>, ThenCalculatorOutcome<?>> {

    @Test
    public void addition() {
        given().turned_on();
        when().adds(4).and().adds(5);
        then().shows(9);
    }

    @Test
    public void multiply() {
        given().turned_on().and().initialized_with_$_state(2);
        when().multiplies_by(2);
        then().shows(4);
    }

    @Test
    public void power() {
        given().turned_on().and().initialized_with_$_state(4);
        when().powerBy(2);
        then().shows(16);
    }

    @Test
    @NotImplementedYet("do this later")
    public void sinus() {
    }

}
