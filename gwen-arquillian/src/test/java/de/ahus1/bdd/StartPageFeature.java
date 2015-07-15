package de.ahus1.bdd;

import de.ahus1.bdd.website.ResultPage;
import de.ahus1.bdd.website.StartPage;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.Page;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import static com.shazam.gwen.Gwen.*;

@RunWith(Arquillian.class)
public class StartPageFeature {

    // This needs to be present so that Arquillian starts Graphene.
    @Drone
    protected WebDriver browser;

    @Page
    private StartPage startPage;

    @Before
    public void setup() {
        browser.manage().window().setSize(new Dimension(1200,800));
    }

    /**
     * The is the very simple test.
     */
    @Test
    public void szenarioStatPage() {
        given(startPage).isOpenedInBrowser();
        // no when
        then(startPage).pageTitleIs("Willkommen!");
    }

    @Page
    private ResultPage resultPage;

    /**
     * This is the standard case if I define all pages in the header.
     */
    @Test
    public void szenarioSearchWithMatchesExternalVar() {
        given(startPage).isOpenedInBrowser();
        when(startPage).searchesFor("hystrix");
        then(resultPage).showsAResultCountOf(3);
    }

    /**
     * The outcome of an action is the result page. You can use then() to
     * trigger assertions. The line end comment allows me to wrap the line so
     * that <code>when()</code> is again on its own line starting correctly
     * indented.
     */
    @Test
    public void szenarioSearchWithMatches() {
        given(startPage).isOpenedInBrowser();
        ResultPage resultPage =
                when(startPage).searchesFor("bdd");
        then(resultPage).showsAResultCountOf(2);
    }

}
