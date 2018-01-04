package de.ahus1.bdd.calculator.adapter.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Alexander Schwartz 2017
 */
@Repository
public interface CalculatorJpaRepository extends JpaRepository<CalculatorJpa, Long> {
}
