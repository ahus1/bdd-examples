package de.ahus1.bdd;

import de.ahus1.bdd.calculator.CalculatorSUT;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static com.shazam.gwen.Gwen.given;
import static com.shazam.gwen.Gwen.then;
import static com.shazam.gwen.Gwen.when;

/**
 * In Order to avoid stupid mistakes
 * As a cautious person
 * I use a calculator.
 */
@RunWith(Parameterized.class)
public class FeatureCalculatorParameterized {
    // The Fixture
    private CalculatorSUT theCalculator = new CalculatorSUT();

    private long val1, val2, result;

    public FeatureCalculatorParameterized(long val1, long val2, long result) {
        this.val1 = val1;
        this.val2 = val2;
        this.result = result;
    }

    @Parameterized.Parameters(name = "Sum of {0} and {1} should be {2}")
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
