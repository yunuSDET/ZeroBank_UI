
Feature: Find Transactions in Account Activity

  Background:
    Given the user is logged in
    And the user clicks "Online Banking" link
    And the user clicks "Account Activity" link
    And the user clicks "Find Transactions" link


  Scenario: Search date range
    When the user enters date range from "2012-09-01" to "2012-09-06"
    And clicks search
    Then results table should only show transactions dates between "2012-09-01" to "2012-09-06"
    And the results should be sorted by most recent date
    When the user enters date range from "2012-09-02" to "2012-09-06"
    And clicks search
    Then results table should only show transactions dates between "2012-09-02" to "2012-09-06"
    And the results table should only not contain transactions dated "2012-09-01"


  Scenario Outline: Search description functionality
    When the user enters description "<keyword>"
    And clicks search
    Then results table should only show descriptions containing "<contain>"
    But results table should not show descriptions containing "<notContain>"
    Examples:
      | keyword | contain | notContain |
      | ONLINE  | ONLINE  | OFFICE     |
      | OFFICE  | OFFICE  | ONLINE     |
      | online  | ONLINE  | OFFICE     |


  Scenario: Type

    And clicks search
    Then results table should show at least one result under "Deposit"
    Then results table should show at least one result under "Withdrawal"

    When user selects type "Deposit"
    And clicks search
    Then results table should show at least one result under "Deposit"
    But results table should show no result under "Withdrawal"

    When user selects type "Withdrawal"
    And clicks search
    Then results table should show at least one result under "Withdrawal"
    But results table should show no result under "Deposit"
