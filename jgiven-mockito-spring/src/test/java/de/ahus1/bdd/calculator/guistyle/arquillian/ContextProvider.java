package de.ahus1.bdd.calculator.guistyle.arquillian;

import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.arquillian.test.spi.enricher.resource.ResourceProvider;

import java.lang.annotation.Annotation;
import java.net.URL;

/**
 * Provider for the port the application is running on.
 *
 * @author Alexander Schwartz 2016
 */
public class ContextProvider implements ResourceProvider {

    private static ThreadLocal<URL> url = new ThreadLocal<>();

    public static void setUrl(URL url) {
        ContextProvider.url.set(url);
    }

    public static void reset() {
        url.remove();
    }

    @Override
    public boolean canProvide(Class<?> type) {
        return URL.class.isAssignableFrom(type);
    }

    @Override
    public Object lookup(ArquillianResource resource, Annotation... qualifiers) {
        return url.get();
    }
}
