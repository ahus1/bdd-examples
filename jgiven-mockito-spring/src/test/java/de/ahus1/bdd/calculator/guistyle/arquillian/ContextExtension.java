package de.ahus1.bdd.calculator.guistyle.arquillian;


import org.jboss.arquillian.core.spi.LoadableExtension;
import org.jboss.arquillian.graphene.location.CustomizableURLResourceProvider;
import org.jboss.arquillian.test.spi.enricher.resource.ResourceProvider;

/**
 * Extension for Arquillian to find the URL context.
 *
 * @author Alexander Schwartz 2016
 */
public class ContextExtension implements LoadableExtension {

    @Override
    public void register(ExtensionBuilder builder) {
        // use "server" for older Arquillian versions, but override for newer versions.
        // builder.service(ResourceProvider.class, ContextProvider.class);
        builder.override(ResourceProvider.class, CustomizableURLResourceProvider.class, ContextProvider.class);
    }
}
