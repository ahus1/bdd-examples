package de.ahus1.bdd.calculator.containerstyle.bdd;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.filter.log.RequestLoggingFilter;
import com.jayway.restassured.filter.log.ResponseLoggingFilter;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.specification.RequestSpecification;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeScenario;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import de.ahus1.bdd.calculator.application.CalculatorApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;

@JGivenStage
public class GivenCalculatorContainerStage<SELF extends GivenCalculatorContainerStage<?>> extends Stage<SELF> {

    @Autowired
    private CalculatorApplication application;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @ProvidedScenarioState
    private RequestSpecification spec;

    public SELF with_an_initial_state() {
        application.reset();
        return self();
    }

    @BeforeScenario
    public void setUp() {
        // this test is using RequestSpecification for the tests. In this setup it will log requests and responses.
        // of course you could use testRestTemplate directly - this is just a matter of taste!
        spec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(testRestTemplate.getRestTemplate().getUriTemplateHandler().expand("/api"))
                //log request and response for better debugging. You can also only log if a requests fails.
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .build();
    }

}
