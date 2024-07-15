Feature: User Registration and Validation

  Background: User registration setup
  	Given navigate to home page
    When click on register option from aside menu
    When enter the following details
      | first_Name     | last_Name | email        | telephone  | password  | confirm_password |
      | priya          | prasad    | dynamicvalue | 1234567890 | Test@1234 | Test@1234        |
    And click on Subscribe option
    And click on accept privacy button
    When click on continue button
    Then user should be able to successfully create account
    
 @myaccount
  Scenario: Validate registration details on My Information page
  	Given user has successfully registered
    When user navigates to the My Information page
    Then registration details should be correctly displayed on the My Information page