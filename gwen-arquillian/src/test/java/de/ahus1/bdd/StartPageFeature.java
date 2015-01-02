package de.ahus1.bdd;

import de.ahus1.bdd.website.ResultPage;
import de.ahus1.bdd.website.StartPage;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.Page;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static com.shazam.gwen.Gwen.*;

// tag::arquillian[]
@RunWith(Arquillian.class)
public class StartPageFeature {

    // end::arquillian[]
    // This needs to be present so that Arquillian starts Graphene.
    // tag::arquillian[]
    @Drone
    protected WebDriver browser;

    @Page
    private StartPage startPage;

    // end::arquillian[]

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
// tag::arquillian[]
    @Test
    public void szenarioSearchWithMatches() {
        given(startPage).isOpenedInBrowser();
        ResultPage resultPage =
                when(startPage).searchesFor("bdd");
        then(resultPage).showsAResultCountOf(3);
    }

}
// end::arquillian[]
