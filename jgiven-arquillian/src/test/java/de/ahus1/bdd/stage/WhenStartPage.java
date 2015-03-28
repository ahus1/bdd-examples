package de.ahus1.bdd.stage;

import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.annotation.Quoted;
import de.ahus1.bdd.website.ResultPage;
import de.ahus1.bdd.website.StartPage;

public class WhenStartPage {

    @ExpectedScenarioState
    private StartPage startPage;

    @ProvidedScenarioState
    private ResultPage resultPage;

    public WhenStartPage searching_for(@Quoted String string) {
        resultPage = startPage.search(string);
        return this;
    }
}
