package de.ahus1.bdd.calculator.containerstyle.bdd;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.specification.RequestSpecification;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import de.ahus1.bdd.calculator.application.CalculatorApplication;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;

@JGivenStage
public class WhenCalculatorContainerAction<SELF extends WhenCalculatorContainerAction<?>> extends Stage<SELF> {

    @ProvidedScenarioState
    private RequestSpecification spec;

    public SELF increment() {
        RestAssured.given().spec(spec).when().post("increment").then().statusCode(HttpStatus.SC_NO_CONTENT);
        return self();
    }

}
