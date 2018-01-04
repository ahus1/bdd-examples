package de.ahus1.bdd.calculator.unitstyle.rest;

import com.tngtech.jgiven.annotation.BeforeStage;
import de.ahus1.bdd.calculator.adapter.commandline.CommandLine;
import de.ahus1.bdd.calculator.adapter.rest.CalculatorStateDto;
import de.ahus1.bdd.calculator.application.CalculatorApplication;
import de.ahus1.bdd.calculator.categories.MediumTest;
import de.ahus1.bdd.calculator.domain.Calculator;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.ComponentScan;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Ensure that the REST resource and all mappers call the application layer as expected.
 * @author Alexander Schwartz 2018
 */
@RunWith(SpringRunner.class)
@WebMvcTest
@ContextConfiguration(classes = {CommandLine.class})
@ComponentScan(basePackages = {"de.ahus1.bdd.calculator.adapter.rest"})
@Category(MediumTest.class)
public class CalculatorResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculatorApplication calculatorApplication;

    private RestTemplate restTemplate;

    @Before
    public void setUp() {
        MockMvcClientHttpRequestFactory requestFactory = new MockMvcClientHttpRequestFactory(mockMvc);
        restTemplate = new RestTemplate(requestFactory);
    }

    @Test
    public void should_retrieve_the_status_of_the_calculator() throws Exception {
        // given ...
        Mockito.when(calculatorApplication.getState()).thenReturn(new Calculator());

        // when/then ...

        // this is the MockMVC style test
        mockMvc.perform(get("/api")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.state", equalTo(0)));

        // this is the RestTemplate style test
        ResponseEntity<CalculatorStateDto> entity = restTemplate.getForEntity("/api", CalculatorStateDto.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(entity.getBody().getState()).isEqualTo(0);

        Mockito.verify(calculatorApplication, Mockito.times(2)).getState();
    }

    @Test
    public void should_increment_the_calculator() throws Exception {
        // given ...

        // when/then ...

        // this is the MockMVC style test
        mockMvc.perform(post("/api/increment")).andDo(print())
                .andExpect(status().isNoContent());

        // this is the RestTemplate style test
        ResponseEntity<Void> entity = restTemplate.postForEntity("/api/increment", null, Void.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);

        Mockito.verify(calculatorApplication, Mockito.times(2)).add(1);
    }

    @Test
    public void should_reset_the_calculator() throws Exception {
        // given ...

        // when/then ...

        // this is the MockMVC style test
        mockMvc.perform(post("/api/reset")).andDo(print())
                .andExpect(status().isNoContent());

        // this is the RestTemplate style test
        ResponseEntity<Void> entity = restTemplate.postForEntity("/api/reset", null, Void.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);

        Mockito.verify(calculatorApplication, Mockito.times(2)).reset();
    }


}
