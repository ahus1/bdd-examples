package de.ahus1.bdd.calculator.domain;

/**
 * @author Alexander Schwartz 2017
 */
public interface CalculatorRepository {
    void store(Calculator calculator);

    Calculator retrieve();
}
