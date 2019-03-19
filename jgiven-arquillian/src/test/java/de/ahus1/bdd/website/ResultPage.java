package de.ahus1.bdd.website;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.assertj.core.api.Fail.fail;

public class ResultPage extends AbstractPage {

    @Drone
    protected WebDriver browser;

    @FindBy(css = "#search h3")
    private List<WebElement> results;

    public int getNumberOfsearchResults() {
        return results.size();
    }

    @FindBy(css = "h3")
    private WebElement contentHeading;

    public void verify() {
        if (browser.findElement(By.className("srp")) == null) {
            fail("wrong page: " + browser.getTitle() + ", URL: "
                    + browser.getCurrentUrl());
        }
    }

}
