

Feature: Add new payee under pay bills

  Scenario: Add a new payee

    Given the user is logged in
    And the user clicks "Online Banking" link
    And the user clicks "Pay Bills" link
    And the user clicks "Add New Payee" link

    And creates new payee using following information
      | Payee Name    | The Law Offices of Hyde, Price & Scharks |
      | Payee Address | 100 Same st, Anytown, USA, 10001         |
      | Account       | Checking                                 |
      | Payee Details | XYZ account                              |
    Then message "The new payee The Law Offices of Hyde, Price & Scharks was successfully created." should be displayed
