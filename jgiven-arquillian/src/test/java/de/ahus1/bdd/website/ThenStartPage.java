package de.ahus1.bdd.website;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Quoted;

import static org.fest.assertions.Assertions.assertThat;

public class ThenStartPage extends Stage<ThenStartPage> {

    @ExpectedScenarioState
    private StartPage startPage;

    public ThenStartPage the_page_title_is(@Quoted String string) {
        assertThat(startPage.getTitle()).isEqualTo(string);
        return this;
    }
}
