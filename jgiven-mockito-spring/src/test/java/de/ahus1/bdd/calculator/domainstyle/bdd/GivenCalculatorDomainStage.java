package de.ahus1.bdd.calculator.domainstyle.bdd;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeScenario;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import de.ahus1.bdd.calculator.application.CalculatorApplication;
import de.ahus1.bdd.calculator.domain.Calculator;
import de.ahus1.bdd.calculator.domain.CalculatorRepository;
import org.mockito.*;
import org.mockito.stubbing.Answer;

import java.util.concurrent.atomic.AtomicReference;

public class GivenCalculatorDomainStage<SELF extends GivenCalculatorDomainStage<?>> extends Stage<SELF> {

    @Mock
    private CalculatorRepository calculatorRepository;

    @ProvidedScenarioState
    @Spy
    @InjectMocks
    private CalculatorApplication calculatorApplication;

    @BeforeScenario
    public void init() {
        MockitoAnnotations.initMocks(this);

        // this mocks the JPA repository with an ad-hoc in memory repository
        AtomicReference<Calculator> storage = new AtomicReference<>();

        Mockito.when(calculatorRepository.retrieve())
                .thenAnswer((Answer<Calculator>) invocation -> {
                    Calculator c = storage.get();
                    if (c == null) {
                        return new Calculator();
                    }
                    return c;
                });

        Mockito.doAnswer((Answer<Void>) invocation -> {
            Calculator c = (Calculator) invocation.getArguments()[0];
            storage.set(c);
            return null;
        }).when(calculatorRepository).store(Matchers.any(Calculator.class));
    }

    public SELF with_an_initial_state() {
        calculatorApplication.reset();
        return self();
    }

}
