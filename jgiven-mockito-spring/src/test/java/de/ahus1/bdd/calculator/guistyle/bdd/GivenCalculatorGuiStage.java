package de.ahus1.bdd.calculator.guistyle.bdd;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import de.ahus1.bdd.calculator.application.CalculatorApplication;
import de.ahus1.bdd.calculator.guistyle.website.StartPage;
import org.jboss.arquillian.graphene.Graphene;
import org.springframework.boot.test.mock.mockito.SpyBean;

@JGivenStage
public class GivenCalculatorGuiStage<SELF extends GivenCalculatorGuiStage<?>> extends Stage<SELF> {

    // @SpyBean must only be present once within the test application context.
    // it's probably a good practice to have all @SpyBean annotations in the GIVEN stage.
    @SpyBean
    private CalculatorApplication calculatorApplication;

    @ProvidedScenarioState
    private StartPage startPage;

    public SELF browser_opened_on_start_page() {
        startPage = Graphene.goTo(StartPage.class);
        startPage.verify();
        return self();
    }

}
