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

  @registration
  Scenario: Registered account should be successfully login
    Given Regisrted account details should be fetched
    When enter the emailID value fetched from excel sheet
    And enter the password value "Test@1234"
    Then user should be logged in successfully

  @registration
  Scenario: Validate registration details are reflects on My Information page
    When click on register option from aside menu
    When enter the following details
      | first_Name | last_Name | email        | telephone  | password  | confirm_password |
      | priya      | prasad    | dynamicvalue | 1234567890 | Test@1234 | Test@1234        |
    And click on Subscribe option
    And click on accept privacy button
    When click on continue button
    Then user has successfully registered
    When user navigates to the My Information page
    Then following details should be correctly displayed:
      | FirstName | LastName | Email        | Telephone  |
      | priya     | prasad   | dynamicvalue | 1234567890 |
