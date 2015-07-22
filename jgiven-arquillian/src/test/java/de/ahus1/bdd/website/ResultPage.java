package de.ahus1.bdd.website;

import com.google.common.net.MediaType;
import com.tngtech.jgiven.attachment.Attachment;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.fragment.Root;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.fest.assertions.Fail.fail;

public class ResultPage {

    @Drone
    protected WebDriver browser;

    @Root
    private WebElement root;

    @FindBy(css = "#content ul li")
    private List<WebElement> results;

    public int getNumberOfsearchResults() {
        return results.size();
    }

    @FindBy(css = "h3")
    private WebElement contentHeading;

    public void verify() {
        if (!contentHeading.getText().startsWith("Suchergebnisse")) {
            fail("wrong page: " + contentHeading.getText() + ", URL: "
                    + browser.getCurrentUrl());
        }
    }

    public Attachment createScreenshot() {
        byte[] screenshot = ((TakesScreenshot) browser).getScreenshotAs(OutputType.BYTES);
        return Attachment
                .fromBinaryBytes(screenshot, com.tngtech.jgiven.attachment.MediaType.PNG)
                .withTitle("screenshot result page");
    }
}
