Feature: Registration Functionality

  Background: 
    Given navigate to home page

@registration
  Scenario: Register account with valid details
    When click on register option from aside menu
    When enter the following details
      | first_Name | last_Name | email        | telephone  | password  | confirm_password |
      | priya      | prasad    | dynamicvalue | 1234567890 | Test@1234 | Test@1234        |
    And click on Subscribe option
    And click on accept privacy button
    When click on continue button
    Then user should be able to successfully create account
    Then store email and password into excel