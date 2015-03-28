package de.ahus1.bdd.website;

import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.annotation.Quoted;

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
