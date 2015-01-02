package de.ahus1.bdd.website;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.Graphene;
import org.jboss.arquillian.graphene.page.Location;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.shazam.gwen.gwt.Given;
import com.shazam.gwen.gwt.Then;
import com.shazam.gwen.gwt.When;

@Location("http://www.ahus1.de")
public class StartPage implements Given<StartPageArranger>,
		When<StartPageActor>, Then<StartPageAsserter> {
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

	private StartPageActor actor = new StartPageActor(this);
	private StartPageArranger arranger = new StartPageArranger(this);
	private StartPageAsserter asserter = new StartPageAsserter(this);

	@Override
	public StartPageActor when() {
		return actor;
	}

	@Override
	public StartPageArranger given() {
		return arranger;
	}

	@Override
	public StartPageAsserter then() {
		return asserter;
	}

	public String getTitle() {
		return contentHeading.getText();
	}
}
