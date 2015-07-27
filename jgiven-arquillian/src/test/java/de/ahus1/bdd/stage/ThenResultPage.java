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

    public ThenResultPage the_result_page_shows_a_result_count_of(int i) {
        assertThat(resultPage.getNumberOfsearchResults()).isEqualTo(i);
        currentStep.addAttachment(resultPage.createScreenshot());
        return this;
    }
}
