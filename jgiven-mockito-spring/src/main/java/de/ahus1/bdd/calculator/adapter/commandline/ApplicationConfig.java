package de.ahus1.bdd.calculator.adapter.commandline;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Alexander Schwartz 2016
 */
@Configuration
@ComponentScan(basePackages = {"de.ahus1.bdd"})
@EntityScan(basePackages = {"de.ahus1.bdd.calculator.adapter.jpa"})
@EnableJpaRepositories(basePackages = {"de.ahus1.bdd.calculator.adapter.jpa"})
public class ApplicationConfig {
}
