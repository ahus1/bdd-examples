package de.ahus1.bdd.website;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.Graphene;
import org.jboss.arquillian.graphene.page.Location;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Location("http://www.ahus1.de")
public class StartPage {

    @Drone
    private WebDriver browser;

    @FindBy(className = "search-button")
    private WebElement searchButton;

    @FindBy(className = "search-input")
    private WebElement searchInput;

    @FindBy(css = "body")
    private WebElement root;

    @FindBy(css = "h1")
    private WebElement contentHeading;

    public ResultPage search(String term) {
        Graphene.waitGui().until().element(contentHeading).is().visible();
        searchInput.sendKeys(term);
        searchButton.click();
        ResultPage resultPage = Graphene.createPageFragment(ResultPage.class,
            root);
        resultPage.verify();
        return resultPage;
    }

    public String getTitle() {
        return contentHeading.getText();
    }
}
