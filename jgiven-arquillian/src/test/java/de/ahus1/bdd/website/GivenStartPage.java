package de.ahus1.bdd.website;

import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jboss.arquillian.graphene.Graphene;

public class GivenStartPage {

    @ProvidedScenarioState
    StartPage startPage;

    public GivenStartPage the_start_page_is_opened_in_browser() {
        startPage = Graphene.goTo(StartPage.class);
        return this;
    }

}
