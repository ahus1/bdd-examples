package de.ahus1.bdd.calculator.guistyle;

import de.ahus1.bdd.calculator.adapter.commandline.ApplicationConfig;
import de.ahus1.bdd.calculator.adapter.commandline.CommandLine;
import de.ahus1.bdd.calculator.categories.SlowTest;
import de.ahus1.bdd.calculator.common.Story;
import de.ahus1.bdd.calculator.guistyle.bdd.GivenCalculatorGuiStage;
import de.ahus1.bdd.calculator.guistyle.bdd.ThenCalculatorGuiOutcome;
import de.ahus1.bdd.calculator.guistyle.bdd.WhenCalculatorGuiAction;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.boot.test.context.SpringBootTest;

@Story("To avoid stupid calculation errors I use a calculator")
@Category(SlowTest.class)
@SpringBootTest(classes = {ApplicationConfig.class, CommandLine.class, CalculatorTestContext.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FeatureCalculatorGui extends AbstractGuiFeature<GivenCalculatorGuiStage<?>,
        WhenCalculatorGuiAction<?>, ThenCalculatorGuiOutcome<?>> {

    @Test
    public void should_be_able_to_increment() {
        given().browser_opened_on_start_page();
        when().increment_is_clicked();
        then().state_$_is_shown(1)
                .and().increment_has_been_called();
    }

}
