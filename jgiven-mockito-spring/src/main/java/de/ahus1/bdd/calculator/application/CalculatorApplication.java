package de.ahus1.bdd.calculator.application;

import de.ahus1.bdd.calculator.domain.Calculator;
import de.ahus1.bdd.calculator.domain.CalculatorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Alexander Schwartz 2017
 */
@Component
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CalculatorApplication {

    private final CalculatorRepository calculatorRepository;

    public void add(long val) {
        log.info("adding {} to the calculator...", val);
        Calculator calculator = calculatorRepository.retrieve();
        calculator.add(val);
        calculatorRepository.store(calculator);
        log.info("... done (now: {})", calculator.getState());
    }

    public void reset() {
        log.info("resetting calculator...");
        Calculator calculator = new Calculator();
        calculatorRepository.store(calculator);
        log.info("... done");
    }

    public Calculator getState() {
        return calculatorRepository.retrieve();
    }
}
