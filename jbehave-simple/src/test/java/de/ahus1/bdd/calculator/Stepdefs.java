package de.ahus1.bdd.calculator;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.embedder.Embedder;

public class Stepdefs extends Embedder{

    Calculator c = new Calculator();

    @Given("^I have (\\d+) cukes in my belly$")
    public void I_have_cukes_in_my_belly(long val) throws Throwable {
        c.add(val);
    }

    @When("^I wait (\\d+) hour$")
    public void I_wait_hour(int arg1) throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new RuntimeException();
    }

    @Then("^my belly should growl$")
    public void my_belly_should_growl() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new RuntimeException();
    }
}
