package de.ahus1.bdd.website;

import org.awaitility.Awaitility;
import org.jboss.arquillian.graphene.Graphene;
import org.jboss.arquillian.graphene.page.Location;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Location("https://www.google.com/")
public class StartPage extends AbstractPage {

    @FindBy(css = "input[name=btnK]")
    private List<WebElement> searchButton;

    @FindBy(css = "input[name=q]")
    private WebElement searchInput;

    public ResultPage search(String term) {
        Graphene.waitGui().until().element(searchInput).is().visible();
        searchInput.sendKeys(term);
        Awaitility.await().pollInSameThread().until(() -> {
            // try multiple times due to ajax until it works
            searchButton.stream().filter(b -> searchInput.isDisplayed())
                    // .reduce((first, second) -> second) // get last element
                    .findFirst()
                    .get().click();
            return true;
        });
        return instanceOfPage(ResultPage.class);
    }

    public String getTitle() {
        return browser.getTitle();
    }

    @Override
    public void verify() {
        Graphene.waitGui().until().element(searchButton.get(0)).is().visible();
    }
}
