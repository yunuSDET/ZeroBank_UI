Feature: Navigating to specific accounts in Accounts Activity

 @wip
  Scenario Outline: Options account redirect
    Given the user is logged in
    And the user clicks "Online Banking" link
    And the user clicks "Account Summary" link
    And the user clicks "<Options>" link
    Then the Account Activity page should be displayed
    And Account drop down should have "<Options>" selected
    Examples:
      | Options     |
      | Savings     |
      | Brokerage   |
      | Checking    |
      | Credit Card |
      | Loan        |


