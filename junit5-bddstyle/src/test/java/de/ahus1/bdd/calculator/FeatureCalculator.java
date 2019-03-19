package de.ahus1.bdd.calculator;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

/**
 * As a user I want to use a calculator to avoid silly mistakes.
 * <p>
 * ... use prefix "should_" to describe desired behavior
 * ... use "_when_" for describing different situations (optional)
 * ... prefix method name to indicate what method is being tested (but this is technical)
 */
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class FeatureCalculator {

    @Nested
    class Additions {
        @Test
        public void should_cope_with_additions() {
            // given ...
            // ... a just turned on calculator
            Calculator c = new Calculator();

            // when ...
            c.add(4);
            c.add(5);

            // then ...
            assertThat(c.getState()).isEqualTo(9);
        }

        @Test
        public void should_throw_exception_on_adding_when_numbers_are_too_big() {
            // given ...
            // ... a just turned on calculator
            Calculator c = new Calculator();

            // when ...
            c.add(Long.MAX_VALUE);
            Throwable thrown = catchThrowable(() -> {
                c.add(1);
            });

            // then ...
            assertThat(thrown).hasMessageContaining("long overflow").isInstanceOf(ArithmeticException.class);
        }
    }

    @Nested
    class Multiplications {

        @Test
        public void should_cope_with_multiplications() {
            // given ...
            // ... a turned on calculator
            Calculator c = new Calculator();
            // ... with initial value of 2
            c.set(2);

            // when ...
            c.multiplyBy(2);

            // then ...
            assertThat(c.getState()).describedAs("result of 2*2").isEqualTo(4);
        }

        @Test
        public void should_throw_exception_on_multiplying_when_numbers_are_too_big() {
            // given ...
            // ... a just turned on calculator
            Calculator c = new Calculator();

            // when ...
            c.add(Long.MAX_VALUE);
            Throwable thrown = catchThrowable(() -> {
                c.multiplyBy(2);
            });

            // then ...
            assertThat(thrown).hasMessageContaining("long overflow").isInstanceOf(ArithmeticException.class);
        }
    }

    @Test
    public void should_accept_setting_current_state() {
        // given ...
        // ... a turned on calculator
        Calculator c = new Calculator();

        // when ...
        c.set(2);

        // then ...
        assertThat(c.getState()).isEqualTo(2);
    }

    @Test
    public void should_cope_with_exponentials() {
        // given ...
        // ... a turned on calculator
        Calculator c = new Calculator();
        // ... with initial value of 4
        c.set(4);

        // when ...
        // ... calculating the power of two
        c.power(2);

        // then ...
        assertThat(c.getState()).isEqualTo(16);
    }

    @Test
    @Disabled("do this later")
    public void should_cope_with_sinus() {
    }

}
