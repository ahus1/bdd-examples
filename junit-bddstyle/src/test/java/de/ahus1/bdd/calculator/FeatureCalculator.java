package de.ahus1.bdd.calculator;

import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FeatureCalculator {

    @Test
    public void should_cope_with_additions() {
        // given ...
        // ... a turned on calculator
        Calculator c = new Calculator();

        // when ...
        c.add(4);
        c.add(5);

        // then ...
        assertThat(c.getState()).isEqualTo(9);
    }

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
    @Ignore("do this later")
    public void should_cope_with_sinus() {
    }

}
