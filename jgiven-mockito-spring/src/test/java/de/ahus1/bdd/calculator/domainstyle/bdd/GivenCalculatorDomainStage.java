package de.ahus1.bdd.calculator.domainstyle.bdd;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeScenario;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import de.ahus1.bdd.calculator.adapter.inmemory.CalculatorInMemoryRepository;
import de.ahus1.bdd.calculator.application.CalculatorApplication;
import de.ahus1.bdd.calculator.domain.CalculatorRepository;
import org.mockito.*;

public class GivenCalculatorDomainStage<SELF extends GivenCalculatorDomainStage<?>> extends Stage<SELF> {

    // You can provide alternative implementations. Once you add the @Spy annotation,
    // the @InjectMocks annotation will inject them.
    @Spy
    private CalculatorRepository calculatorRepository = new CalculatorInMemoryRepository();

    // to mock beans use @Mock annotation for them. They will be injected using @InjectMocks as well.

    @ProvidedScenarioState
    @Spy
    @InjectMocks
    private CalculatorApplication calculatorApplication;

    @BeforeScenario
    public void init() {
        MockitoAnnotations.initMocks(this);
        // after initMocks() you can use the standard mockito functionality to mock methods and instances.
    }

    public SELF with_an_initial_state() {
        calculatorApplication.reset();
        // every step can use mock() to adapt the pre-conditions, although this doesn't seem to be of much use here.
        return self();
    }

}
