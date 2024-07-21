Feature: My Account Page Functionality

  Background: Do sucessful login for my account page
    Given Navigate to login page
    When user enters the valid email address "durgaprasad534211@gmail.com" into email text field
    And user enters the valid password "Test@1234" into password text field
    And click on Login button

  @product
  Scenario Outline: After successful login, validate the UI elements on the My Account page
    When the user logs in successfully and navigates to the My Account page
    And enters the product "<product>" in the search box
    And clicks on the search button
    Then I should see results related to "<product>"
    And the results should include:
    # added expected results for showing header in logs
    	|expectedResults  |
      | <searchResults> |

    Examples: 
      | product | searchResults                                    |
      | MacBook | MacBook, MacBook Air, MacBook Pro                |
      | apple   | Apple Cinema 30"                                 |
      | Samsung | Samsung SyncMaster 941BW,Samsung Galaxy Tab 10.1 |
