package de.ahus1.bdd.calculator.containerstyle.bdd;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.specification.RequestSpecification;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import de.ahus1.bdd.calculator.adapter.rest.CalculatorStateDto;
import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;

@JGivenStage
public class ThenCalculatorContainerOutcome<SELF extends ThenCalculatorContainerOutcome<?>> extends Stage<SELF> {

    @ProvidedScenarioState
    private RequestSpecification spec;

    public SELF state(long expectedState) {
        CalculatorStateDto stateFromService = RestAssured.given().spec(spec).when().get()
                .then().statusCode(HttpStatus.SC_OK).extract().as(CalculatorStateDto.class);
        Assertions.assertThat(stateFromService.getState()).isEqualTo(expectedState);
        return self();
    }

}
