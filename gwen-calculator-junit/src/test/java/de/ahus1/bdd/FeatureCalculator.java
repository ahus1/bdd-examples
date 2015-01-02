package de.ahus1.bdd;

import de.ahus1.bdd.calculator.CalculatorSUT;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

// tag::simpleaddition[]
import static com.shazam.gwen.Gwen.given;
import static com.shazam.gwen.Gwen.when;
import static com.shazam.gwen.Gwen.then;

/**
 * In Order to avoid stupid mistakes
 * As a cautious person
 * I use a calculator.
 */
public class FeatureCalculator {

    // The system under test (SUT)
    private CalculatorSUT theCalculator =
            new CalculatorSUT();

    @Test
    public void scenarioSimpleAddition() {
        given(theCalculator).turnedOn();
        when(theCalculator).adds(4).adds(5);
        then(theCalculator).shows(9);
    }

    // end::simpleaddition[]

    @Test
    public void scenarioMultiply() {
        /*
         * given: describes the relevant state before the actions from user's
		 * perspective
		 */
        given(theCalculator).isInitializedWith(2);
        /*
         * when: takes action and changes the state. Don't model flow here, have
		 * one action here.
		 */
        when(theCalculator).multipliesBy(2);
        /*
         * then: verifies observable outcomes by the user
		 */
        then(theCalculator).shows(4);
    }

    @RunWith(Parameterized.class)
    public static class AddSet {
        // The Fixture
        private CalculatorSUT theCalculator = new CalculatorSUT();

        private long val1, val2, result;

        public AddSet(long val1, long val2, long result) {
            this.val1 = val1;
            this.val2 = val2;
            this.result = result;
        }

        @Parameters(name = "Sum of {0} and {1} should be {2}")
        public static Collection<?> values() {
            return Arrays.asList(new Object[][]
                    {{1, 1, 2}, {2, 2, 4}, {3, 3, 6}});
        }

        @Test
        public void scenarioAdd() {
            given(theCalculator).isInitializedWith(val1);
            when(theCalculator).adds(val2);
            then(theCalculator).shows(result);
        }
    }

    @Test
    public void scenarioPower() {
        given(theCalculator).isInitializedWith(4);
        when(theCalculator).powerBy(2);
        then(theCalculator).shows(16);
    }

// tag::simpleaddition[]
}
// end::simpleaddition[]
