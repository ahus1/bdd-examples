package de.ahus1.bdd.calculator.adapter.jpa;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Alexander Schwartz 2017
 */
@Entity
@Data
public class CalculatorJpa {

    @Id
    @SequenceGenerator(name = "calculator_id_seq", sequenceName = "calculator_id_seq")
    @Column(name = "calculator_id")
    private long id;

    @Version
    private long version;

    private long state;
}
