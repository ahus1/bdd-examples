package de.ahus1.bdd.calculator.guistyle;

import com.tngtech.jgiven.integration.spring.SpringRuleScenarioTest;
import de.ahus1.bdd.calculator.adapter.commandline.ApplicationConfig;
import de.ahus1.bdd.calculator.adapter.commandline.CommandLine;
import de.ahus1.bdd.calculator.categories.SlowTest;
import de.ahus1.bdd.calculator.common.Story;
import de.ahus1.bdd.calculator.guistyle.arquillian.ContextRule;
import de.ahus1.bdd.calculator.guistyle.bdd.GivenCalculatorGuiStage;
import de.ahus1.bdd.calculator.guistyle.bdd.ThenCalculatorGuiOutcome;
import de.ahus1.bdd.calculator.guistyle.bdd.WhenCalculatorGuiAction;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit.ArquillianTest;
import org.jboss.arquillian.junit.ArquillianTestClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.WebApplicationContext;

import java.net.MalformedURLException;
import java.net.URL;

@Story("To avoid stupid calculation errors I use a calculator")
@Category(SlowTest.class)
@SpringBootTest(classes = {ApplicationConfig.class, CommandLine.class, CalculatorTestContext.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class AbstractGuiFeature<GIVEN, WHEN, THEN> extends SpringRuleScenarioTest<GIVEN, WHEN, THEN> {

    @ClassRule
    public static ArquillianTestClass arquillianTestClass = new ArquillianTestClass();

    @Value("${local.server.port}")
    private int port;

    @Autowired
    private WebApplicationContext context;

    @Rule
    public ArquillianTest arquillianTest = new ArquillianTest();

    @Rule
    public ContextRule contextRule = new ContextRule(
            () -> {
                try {
                    return new URL("http://localhost:"
                            + port + context.getServletContext().getContextPath() + "/");
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            });

    @Drone
    protected WebDriver browser;

}
