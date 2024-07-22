Feature: My Account Page Functionality

  Background: Do sucessful login for my account page
    Given Navigate to login page
    When user enters the valid email address "durgaprasad534211@gmail.com" into email text field
    And user enters the valid password "Test@1234" into password text field
    And click on Login button

  Scenario Outline: After successful login, validate the UI elements on the My Account page
    When the user logs in successfully and navigates to the My Account page
    And enters the product "<product>" in the search box
    And clicks on the search button
    Then I should see results related to "<product>"
    And the results should include:
      | <searchResults> |

    Examples: 
      | product | searchResults                                    |
      | MacBook | MacBook, MacBook Air, MacBook Pro                |
      | apple   | Apple Cinema 30"                                 |
      | Samsung | Samsung SyncMaster 941BW,Samsung Galaxy Tab 10.1 |

  @product
  Scenario Outline: After successful login, validate the UI elements on the My Account page
    When the user logs in successfully and navigates to the My Account page
    And enters the product "<product>" in the search box
    And clicks on the search button
    Then check the description of product:
      | <productDesc> |
    Then check the price of product without tax
      | <pricesWithoutTax> |
    Then check the price of product with tax
      | <pricesWithTax> |

    Examples: 
      | product | productDesc                                                                                            | pricesWithoutTax | pricesWithTax   |
      | apple   | The 30-inch Apple Cinema HD Display delivers an amazing 2560 x 1600 pixel resolution. Designed speci.. | $110.00 $122.00  | Ex Tax: $90.00  |
      | phone   | iPhone is a revolutionary new mobile phone that allows you to make a call by simply tapping a name o.. | $123.20          | Ex Tax: $101.00 |

  @product1
  Scenario Outline: After successful login, validate the UI elements on the My Account page
    When the user logs in successfully and navigates to the My Account page
    And enters the product "<product>" in the search box
    And clicks on the search button
    And click on addtocart button
    Then validate the sucessMsg add to cart "Success: You have added <product> to your shopping cart!"
    Then validate the productName shows in hyperlink "<product>"
    And click on hyper link from sucess msg
    Then user navigate to product detail page which displays the product header "<product>"

    Examples: 
      | product     |
      | iPhone      |
      | MacBook Air |
