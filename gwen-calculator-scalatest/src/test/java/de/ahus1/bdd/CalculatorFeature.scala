package de.ahus1.bdd

import de.ahus1.bdd.calculator.CalculatorSUT
import org.scalatest.FeatureSpec

class CalculatorFeature extends FeatureSpec with GwenTrait {

  val theCalculator = new CalculatorSUT();

  feature("calculator") {

    scenario("simple addition") {
      given(theCalculator) turnedOn;
      when(theCalculator) adds 4 adds 5
      then(theCalculator) shows 9
    }

    scenario("multiply") {
      given(theCalculator) isInitializedWith 2
      when(theCalculator) multipliesBy 2
      then(theCalculator) shows 4
    }

    scenario("power") {
      given(theCalculator) isInitializedWith 4
      when(theCalculator) powerBy 2
      then(theCalculator) shows 16
    }

  }

}
