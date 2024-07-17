Feature: My Account Page Functionality

  Background: Do sucessful login for my account page
    Given Navigate to login page
    When user enters the valid email address "durgaprasad534211@gmail.com" into email text field
    And user enters the valid password "Test@1234" into password text field
    And click on Login button

  @myaccount
  Scenario: after successful login validate the UI elements in myAccount page
    Given user login sucessfully and navigated to My Account page
    Then following headers are displayed in my account page
      | My Account           |
      | My Orders            |
      | My Affiliate Account |
      | Newsletter           |
    Then following aside menu are displayed
      | My Account         |
      | Edit Account       |
      | Password           |
      | Address Book       |
      | Wish List          |
      | Order History      |
      | Downloads          |
      | Recurring Payments |
      | Rewards Points     |
      | Returns            |
      | Transactions       |
      | News Letters       |
      | Logout             |
