package de.ahus1.bdd.calculator.adapter.jpa;

import de.ahus1.bdd.calculator.domain.Calculator;
import de.ahus1.bdd.calculator.domain.CalculatorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Alexander Schwartz 2017
 */
@Component
@RequiredArgsConstructor
public class CalculatorRepositoryImplementation implements CalculatorRepository {

    private final CalculatorJpaRepository calculatorJpaRepository;

    private final CalculatorJpaMapper calculatorJpaMapper;

    @Override
    public void store(Calculator calculator) {
        CalculatorJpa jpa = calculatorJpaRepository.findOne(1L);
        if(jpa != null) {
            calculatorJpaMapper.updateJpa(jpa, calculator);
        } else {
            jpa = calculatorJpaMapper.toJpa(calculator);
            jpa.setId(1);
        }
        calculatorJpaRepository.save(jpa);
    }

    @Override
    public Calculator retrieve() {
        CalculatorJpa jpa = calculatorJpaRepository.findOne(1L);
        Calculator domain;
        if(jpa == null) {
            domain = new Calculator();
        } else {
            domain = calculatorJpaMapper.fromJpa(jpa);
        }
        return domain;
    }
}
