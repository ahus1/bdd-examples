package de.ahus1.bdd.calculator.adapter.jpa;

import de.ahus1.bdd.calculator.domain.Calculator;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

/**
 * @author Alexander Schwartz 2017
 */
@Mapper(componentModel = "spring")
public interface CalculatorJpaMapper {
    CalculatorJpa toJpa(Calculator c);

    Calculator fromJpa(CalculatorJpa c);

    void updateJpa(@MappingTarget CalculatorJpa jpa, Calculator calculator);
}
