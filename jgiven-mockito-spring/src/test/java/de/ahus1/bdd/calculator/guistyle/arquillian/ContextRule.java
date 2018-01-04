package de.ahus1.bdd.calculator.guistyle.arquillian;

import lombok.RequiredArgsConstructor;
import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

import java.net.URL;
import java.util.function.Supplier;

/**
 * JUnit Rule to apply URL or port mappings to a JUnit test.
 *
 * @author Alexander Schwartz 2016
 */
@RequiredArgsConstructor
public class ContextRule implements MethodRule {
    private final Supplier<URL> contextUrl;

    @Override
    public Statement apply(Statement base, FrameworkMethod method, Object target) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                ContextProvider.setUrl(contextUrl.get());
                try {
                    base.evaluate();
                } finally {
                    ContextProvider.reset();
                }
            }
        };
    }
}
