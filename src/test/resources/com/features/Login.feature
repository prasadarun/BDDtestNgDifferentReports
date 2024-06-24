Feature: Login Functionality

  # repeated statement are represented with background keyword sho that will remove steps duplication
  Background: 
    Given Navigate to login page

  @login
  Scenario: Login with valid credentails
    When User enters the valid email address "durgaprasad534211@gmail.com" into email text field
    And User enters the valid password "Test@123" into password text field
    And Click on Login button
		Then User should be login successfully
		
  @login
  Scenario: Login with invalid email
    When User enters the invalid email address "durgaprasad" into email text field
    And User enters the valid password "Test@1234" into password text field
    And Click on Login button
    Then User should not be login successfully

 @login
  Scenario: Login with invalid password
    When User enters the invalid password "durgaprasad534211@gmail.com" into password text field
    And User enters the valid password "Test@1234" into password text field
    And Click on Login button
    Then User should not be login successfully

  
  Scenario: Login with empty email
    And User enters the valid password "Test@1234" into password text field
    And Click on Login button
    Then User should not be login successfully
