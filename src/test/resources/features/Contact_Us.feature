@contact-us @Regression

Feature: WebDriver university -Contact Us Page

  Background:
    Given I access the WebDriver university Contact Us Page


  Scenario: Validate Successful Submission-Unique Data
    When I enter a unique fist name
    And I enter a unique last name
    And I enter a unique email address
    And I enter a unique comment
    And I click on submit button
    Then I should be presented with a successful contact us submission message


  Scenario: Validate Successful Submission with specific  Data
    When I enter a specific fist name Mahesh
    And I enter a specific last name mahJad
    And I enter a specific email address maheshj@gmail.com
    And I enter a specific comment "How are you?"
    And I click on submit button
    Then I should be presented with a successful contact us submission message