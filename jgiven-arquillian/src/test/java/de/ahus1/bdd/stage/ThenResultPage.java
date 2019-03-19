package de.ahus1.bdd.stage;

import com.tngtech.jgiven.CurrentStep;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import de.ahus1.bdd.website.ResultPage;

import static org.assertj.core.api.Assertions.assertThat;

public class ThenResultPage extends Stage<ThenResultPage> {

    @ExpectedScenarioState
    private ResultPage resultPage;

    @ExpectedScenarioState
    private CurrentStep currentStep;

    public ThenResultPage the_result_shows_at_least_$_results(int numResults) {
        assertThat(resultPage.getNumberOfsearchResults()).isGreaterThan(numResults);
        currentStep.addAttachment(resultPage.createScreenshot());
        return this;
    }
}
