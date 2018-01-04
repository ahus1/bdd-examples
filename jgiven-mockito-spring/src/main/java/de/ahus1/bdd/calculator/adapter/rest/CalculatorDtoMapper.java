package de.ahus1.bdd.calculator.adapter.rest;

import de.ahus1.bdd.calculator.domain.Calculator;
import org.mapstruct.Mapper;

/**
 * @author Alexander Schwartz 2017
 */
@Mapper(componentModel = "spring")
public interface CalculatorDtoMapper {
    CalculatorStateDto toDto(Calculator c);
}
