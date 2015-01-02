package de.ahus1.bdd.testng;

import de.ahus1.bdd.testng.calculator.CalculatorSUT;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.shazam.gwen.Gwen.*;

public class FeatureCalculator {

    // The system under test (SUT)
    private CalculatorSUT theCalculator = new CalculatorSUT();

    @Test
    public void scenarioMultiply() {
        /*
		 * given: describes the relevant state from user's perspective before
		 * any actions are taken.
		 */
        given(theCalculator).isInitializedWith(2);
		/*
		 * when: takes action and changes the state. Don't model flow here, having
		 * one action here is preferred.
		 */
        when(theCalculator).multipliesBy(2);
		/*
		 * then: verifies outcomes observable by the user
		 */
        then(theCalculator).shows(4);
    }

    @DataProvider(name = "sum")
    public static Object[][] values() {
        return new Object[][]{
                // val1, val2, sum
                {1, 1, 2},
                {2, 2, 4},
                {3, 3, 6}
        };
    }

    @Test(dataProvider = "sum")
    public void scenarioAdd(long val1, long val2, long result) {
        given(theCalculator).isInitializedWith(val1);
        when(theCalculator).adds(val2);
        then(theCalculator).shows(result);
    }

    @Test
    public void scenarioPower() {
        given(theCalculator).isInitializedWith(4);
        when(theCalculator).powerBy(2);
        then(theCalculator).shows(16);
    }

}
