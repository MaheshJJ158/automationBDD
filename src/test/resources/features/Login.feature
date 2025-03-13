@Login @Regression

Feature: webdriver university  - Login page

  Background:
    Given I access the WebDriver university Login Page

  @smoke
  Scenario: Login into the the webdriver university page

    When I enter a username webdriver
    And I enter Password webdriver123
    And I click on submit button to login
    Then I validate the alert message


  Scenario: Login into the the webdriver university page

    When I enter a username webdriver
    And I enter Password webdriver1234
    And I click on submit button to login
    Then I validate the failed alert message


  Scenario Outline:  Validate - Successful and Unsuccessful Login
    When I enter a username <username>
    And I enter Password <password>
    And I click on submit button to login
    Then I should be presented with following login validation message <loginValidationMessage>
    Examples:
      | username   | password        | loginValidationMessage |
      | webdriver  | webdriver123    | validation succeeded   |
      | webdriver  | webdriver1     | validation failed      |
      | mahesh_jad | invalidpassword | validation failed      |





