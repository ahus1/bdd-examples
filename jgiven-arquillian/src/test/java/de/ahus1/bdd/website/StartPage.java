package de.ahus1.bdd.website;

import org.jboss.arquillian.graphene.Graphene;
import org.jboss.arquillian.graphene.page.Location;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Location("http://www.ahus1.de")
public class StartPage extends AbstractPage {

    @FindBy(className = "search-button")
    private WebElement searchButton;

    @FindBy(className = "search-input")
    private WebElement searchInput;

    @FindBy(css = "h1")
    private WebElement contentHeading;

    public ResultPage search(String term) {
        Graphene.waitGui().until().element(searchInput).is().visible();
        searchInput.sendKeys(term);
        searchButton.click();
        return instanceOfPage(ResultPage.class);
    }

    public String getTitle() {
        return contentHeading.getText();
    }

    @Override
    public void verify() {
        Graphene.waitGui().until().element(contentHeading).is().visible();
    }
}
