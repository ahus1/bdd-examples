package de.ahus1.bdd.calculator.adapter.commandline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass = true)
public class CommandLine {
    public static void main(String[] args) {
        SpringApplication.run(CommandLine.class, args);
    }
}
