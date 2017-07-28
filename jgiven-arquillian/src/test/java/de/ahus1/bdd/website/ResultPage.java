package de.ahus1.bdd.website;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.assertj.core.api.Fail.fail;

public class ResultPage extends AbstractPage {

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

}
