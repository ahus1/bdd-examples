package de.ahus1.bdd.calculator;

import org.fest.assertions.Assertions;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.fest.assertions.Assertions.assertThat;

public class CalculatorSteps {

    private Calculator c;

    @Given("a calculator I just turned on")
    public void givenACalculatorIJustTurnedOn() {
        c = new Calculator();
    }

    @When("I add $val")
    public void whenIAdd(long val) {
        c.add(val);
    }

    @Then("the result is $val")
    public void thenTheResultIs(long val) {
       assertThat(c.getState()).isEqualTo(val);
    }
}
