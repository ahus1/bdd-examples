package de.ahus1.bdd.calculator;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromRelativeFile;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.reporters.StoryReporterBuilder.Format;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class StackScenarios extends JUnitStory {

    @Override
    public Configuration configuration() {
        URL storyURL = null;
        try {
            // This requires you to start Maven from the project directory
            storyURL = new URL("file://" + System.getProperty("user.dir")
                    + "/src/test/resources/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return new MostUsefulConfiguration().useStoryLoader(
                new LoadFromRelativeFile(storyURL)).useStoryReporterBuilder(
                new StoryReporterBuilder().withFormats(Format.HTML));
    }

    @Override
    public List candidateSteps() {
        return new InstanceStepsFactory(configuration(), new Stepdefs())
                .createCandidateSteps();
    }

    @Override
    @Test
    public void run() {
        try {
            super.run();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}