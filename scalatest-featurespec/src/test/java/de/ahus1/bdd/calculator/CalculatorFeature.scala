import de.ahus1.bdd.calculator.Calculator
import org.expecty.Expecty
import org.scalatest._

class CalculatorFeature extends FeatureSpec with GivenWhenThen with Matchers{

  markup { """
In Order to avoid *stupid* mistakes

As a cautious person

I use a calculator.
           """
  }

  feature("Math"){

    val expect = new Expecty();

    scenario("Simple Addition") {

      Given("the calculator is turned on")
      val c = new Calculator();

      When("the calculator adds 4");
      c.add(4);

      When("the calculator adds 5");
      c.add(5);

      Then("the calculator shows 9");
      expect {
        c.getState equals 9l;
      }

    }

    scenario("Simple Multiplication") {

      Given("the calculator is turned on")
      val c = new Calculator();

      When("the calculator adds 5");
      c add 5;

      When("the calculator multiplies by two");
      c multiplyBy 2;

      Then("the calculator shows 9");
      expect {
        c.getState() == 9l;
      }

    }

  }
}