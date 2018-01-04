package de.ahus1.bdd.calculator.adapter.rest;

import de.ahus1.bdd.calculator.application.CalculatorApplication;
import de.ahus1.bdd.calculator.domain.Calculator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alexander Schwartz 2017
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class CalculatorResource {
    private final CalculatorApplication application;
    private final CalculatorDtoMapper dtoMapper;

    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public CalculatorStateDto read() {
        Calculator calculator = application.getState();
        return dtoMapper.toDto(calculator);
    }

    @RequestMapping(value = "reset", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void reset() {
        application.reset();
    }

    @RequestMapping(value = "increment", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void increment() {
        application.add(1);
    }
}
