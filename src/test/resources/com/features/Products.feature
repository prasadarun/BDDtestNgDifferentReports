Feature: My Account Page Functionality

  Background: Do sucessful login for my account page
    Given Navigate to login page
    When user enters the valid email address "durgaprasad534211@gmail.com" into email text field
    And user enters the valid password "Test@1234" into password text field
    And click on Login button

  @product
  Scenario: after successful login validate the UI elements in myAccount page
    Given user login sucessfully and navigated to My Account page
    When user enter the product "Macbook" in searchbox 
    And click on search button
    