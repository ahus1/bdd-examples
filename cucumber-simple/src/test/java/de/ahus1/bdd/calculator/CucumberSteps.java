package de.ahus1.bdd.calculator;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.fest.assertions.Assertions.assertThat;


public class CucumberSteps {
    Calculator c;

    @Given("^a calculator I just turned on$")
    public void a_calculator_I_just_turned_on()
            throws Throwable {
        c = new Calculator();
    }

    @When("^I add (\\d+)$")
    public void I_add(long number) throws Throwable {
        c.add(number);
    }

    @Then("^the result is (\\d+)$")
    public void the_result_is(long result)
            throws Throwable {
        assertThat(c.getState()).isEqualTo(result);
    }
}
