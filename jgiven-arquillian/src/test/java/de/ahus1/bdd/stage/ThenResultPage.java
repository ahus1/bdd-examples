package de.ahus1.bdd.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import de.ahus1.bdd.website.ResultPage;

import static org.fest.assertions.Assertions.assertThat;

public class ThenResultPage extends Stage<ThenResultPage> {

    @ExpectedScenarioState
    private ResultPage resultPage;

    public ThenResultPage the_result_page_shows_a_result_count_of(int i) {
        assertThat(resultPage.getNumberOfsearchResults()).isEqualTo(i);
        return this;
    }
}
