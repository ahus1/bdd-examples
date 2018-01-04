package de.ahus1.bdd.calculator.unitstyle.jpa;

import de.ahus1.bdd.calculator.adapter.commandline.CommandLine;
import de.ahus1.bdd.calculator.adapter.jpa.CalculatorJpa;
import de.ahus1.bdd.calculator.adapter.rest.CalculatorStateDto;
import de.ahus1.bdd.calculator.application.CalculatorApplication;
import de.ahus1.bdd.calculator.categories.FastTest;
import de.ahus1.bdd.calculator.categories.MediumTest;
import de.ahus1.bdd.calculator.domain.Calculator;
import de.ahus1.bdd.calculator.domain.CalculatorRepository;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockMvcClientHttpRequestFactory;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Ensure that the Repository and all mappers work as expected.
 * @author Alexander Schwartz 2018
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = {CommandLine.class})
@ComponentScan(basePackages = {"de.ahus1.bdd.calculator.adapter.jpa"})
@EntityScan(basePackages = {"de.ahus1.bdd.calculator.adapter.jpa"})
@EnableJpaRepositories(basePackages = {"de.ahus1.bdd.calculator.adapter.jpa"})
@Category(MediumTest.class)
public class CalculatorRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CalculatorRepository calculatorRepository;

    @Test
    public void should_retrieve_a_new_instance_when_called_initially() {
        // when...
        Calculator calculator = calculatorRepository.retrieve();

        // then...
        assertThat(calculator.getState()).isEqualTo(0);
    }

    @Test
    public void should_retrieve_a_previously_stored_instance() {
        // given ...
        Calculator calculator = calculatorRepository.retrieve();
        calculator.setState(1);
        calculatorRepository.store(calculator);
        entityManager.flush();

        // when ...
        Calculator calculator2 = calculatorRepository.retrieve();

        // then ...
        assertThat(calculator.getState()).isEqualTo(calculator2.getState());
    }

}
