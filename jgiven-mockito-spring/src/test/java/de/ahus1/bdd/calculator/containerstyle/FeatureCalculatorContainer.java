package de.ahus1.bdd.calculator.containerstyle;

import com.tngtech.jgiven.integration.spring.SpringRuleScenarioTest;
import de.ahus1.bdd.calculator.adapter.commandline.ApplicationConfig;
import de.ahus1.bdd.calculator.adapter.commandline.CommandLine;
import de.ahus1.bdd.calculator.categories.SlowTest;
import de.ahus1.bdd.calculator.common.Story;
import de.ahus1.bdd.calculator.containerstyle.bdd.GivenCalculatorContainerStage;
import de.ahus1.bdd.calculator.containerstyle.bdd.ThenCalculatorContainerOutcome;
import de.ahus1.bdd.calculator.containerstyle.bdd.WhenCalculatorContainerAction;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@Story("To avoid stupid calculation errors I use a calculator")
@Category(SlowTest.class)
@SpringBootTest(classes = {ApplicationConfig.class, CommandLine.class, CalculatorTestContext.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FeatureCalculatorContainer extends SpringRuleScenarioTest<GivenCalculatorContainerStage<?>,
        WhenCalculatorContainerAction<?>, ThenCalculatorContainerOutcome<?>> {

    @Value("${local.server.port}")
    private int port;

    @Test
    public void should_cope_with_additions() {
        given().with_an_initial_state();
        when().increment();
        then().state(1);
    }

}
