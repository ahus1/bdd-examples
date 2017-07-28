package de.ahus1.bdd.website;

import com.tngtech.jgiven.attachment.Attachment;
import org.jboss.arquillian.drone.api.annotation.Default;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.context.GrapheneContext;
import org.jboss.arquillian.graphene.enricher.PageObjectEnricher;
import org.jboss.arquillian.graphene.enricher.exception.GrapheneTestEnricherException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * @author Alexander Schwartz 2017
 */
public abstract class AbstractPage {

    @Drone
    protected WebDriver browser;

    /**
     * It is easy to instantiate a page with Graphene.goTo(). But this will work only for a
     * that is annotated with @Location.
     */
    public <C extends AbstractPage> C instanceOfPage(Class<C> page) {
        C pageInstance;
        GrapheneContext grapheneContext = GrapheneContext.getContextFor(Default.class);
        WebDriver browser = grapheneContext.getWebDriver();
        try {
            pageInstance = PageObjectEnricher.setupPage(grapheneContext, browser, page);
        } catch (Exception e) {
            throw new GrapheneTestEnricherException("Error while initializing: " + page, e);
        }
        pageInstance.verify();
        return pageInstance;
    }

    public abstract void verify();

    public Attachment createScreenshot() {
        byte[] screenshot = ((TakesScreenshot) browser).getScreenshotAs(OutputType.BYTES);
        return Attachment
                .fromBinaryBytes(screenshot, com.tngtech.jgiven.attachment.MediaType.PNG)
                .withTitle("screenshot result page");
    }

}
