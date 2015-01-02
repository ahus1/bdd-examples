Feature: Basic Arithmethic

  In Order to avoid stupid mistakes
  As a cautious person
  I use a calculator.

  Scenario: simple addition
    Given a calculator I just turned on
    When I add 4
    When
    And I add 5
    Then the result is 9
