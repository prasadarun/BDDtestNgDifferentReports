Feature: My Product Detail page Functionality

  Background: Do sucessful login for my account page
    Given Navigate to login page
    When user enters the valid email address "durgaprasad534211@gmail.com" into email text field
    And user enters the valid password "Test@1234" into password text field
    And click on Login button

  @productDetail
  Scenario Outline: After successful login, validate the UI elements on the product detail page for given product
    When the user logs in successfully and navigates to the My Account page
    And enters the product "<product>" in the search box
    And clicks on the search button
    Given user click on productLink "<product>" and navigated to product detail page
    Then validate the "<availabilitystatus>" of product
    Then validate the "<productCode>" code

    Examples: 
      | product         | availabilitystatus | productCode |
      | iPhone          | Out Of Stock       | product 11  |
      | Apple Cinema 30 | In Stock           | Product 15  |
