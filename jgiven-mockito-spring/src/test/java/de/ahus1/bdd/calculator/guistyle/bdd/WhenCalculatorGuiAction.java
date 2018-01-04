package de.ahus1.bdd.calculator.guistyle.bdd;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.specification.RequestSpecification;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import de.ahus1.bdd.calculator.guistyle.website.StartPage;
import org.apache.http.HttpStatus;

@JGivenStage
public class WhenCalculatorGuiAction<SELF extends WhenCalculatorGuiAction<?>> extends Stage<SELF> {

    @ProvidedScenarioState
    private StartPage startPage;

    public void increment_is_clicked() {
        startPage.clickIncrement();
    }
}
