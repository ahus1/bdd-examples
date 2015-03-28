package de.ahus1.bdd;

import com.tngtech.jgiven.annotation.ScenarioStage;
import com.tngtech.jgiven.junit.ScenarioTest;
import de.ahus1.bdd.website.GivenStartPage;
import de.ahus1.bdd.website.ThenResultPage;
import de.ahus1.bdd.website.ThenStartPage;
import de.ahus1.bdd.website.WhenStartPage;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(Arquillian.class)
public class StartPageFeature extends ScenarioTest<GivenStartPage, WhenStartPage, ThenStartPage> {

    @Drone
    protected WebDriver browser;

    // here we inject a 4th scenario stage using the @ScenarioStage annotation
    @ScenarioStage
    private ThenResultPage thenResultPage;

    /**
     * The is the very simple test.
     */
    @Test
    public void the_start_page_can_be_opened() {
        given().the_start_page_is_opened_in_browser();
        then().the_page_title_is("Willkommen!");
    }

    /**
     * This shows the usage of a 4th stage that is injected using @ScenarioStage
     */
    @Test
    public void searching_works() {
        given().the_start_page_is_opened_in_browser();
        when().searching_for("hystrix");
        thenResultPage
            .then().the_result_page_shows_a_result_count_of(3);
    }

}
