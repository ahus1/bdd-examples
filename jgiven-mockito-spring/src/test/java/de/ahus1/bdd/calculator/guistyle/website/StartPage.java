package de.ahus1.bdd.calculator.guistyle.website;

import org.jboss.arquillian.graphene.Graphene;
import org.jboss.arquillian.graphene.page.Location;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Location("/")
public class StartPage extends AbstractPage {

    @FindBy(id = "increment")
    private WebElement increment;

    @FindBy(id = "state")
    private WebElement state;

    @FindBy(css = "h1")
    private WebElement heading;

    @Override
    public void verify() {
        Graphene.waitGui().until().element(heading).is().visible();
    }

    public void clickIncrement() {
        increment.click();
    }

    public void assertStateIs(long val) {
        Graphene.waitAjax().until().element(state).text().equalToIgnoreCase(Long.toString(val));
    }
}
