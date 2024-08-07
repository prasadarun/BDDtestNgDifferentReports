Feature: My Product Detail page Functionality

  Background: Do sucessful login for my account page
    Given Navigate to login page
    When user enters the valid email address "durgaprasad534211@gmail.com" into email text field
    And user enters the valid password "Test@1234" into password text field
    And click on Login button

  @productDetai
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

  @productDetail
  Scenario Outline: After successful login, validate the adding elements should whishlist should display in wishlist menu
    When the user logs in successfully and navigates to the My Account page
    And enters the product "iPhone" in the search box
    And clicks on the search button
    Given user click on productLink "iPhone" and navigated to product detail page
    When user click on whishList menu
    Then validate the alertMsg add to cart "Success: You have added iPhone to your wish list!"
    When user click on wishListMenu from mainMenu
    Then validate the table cloumns of wishListPage:
      | Image        |
      | Product Name |
      | Model        |
      | Stock        |
      | Unit Price   |
      | Action       |

  @productDetail2
  Scenario Outline: After successful login, validate the total widhlish listed elements should should display in wishlist menu
    When the user logs in successfully and navigates to the My Account page
    And enters the product "iPhone" in the search box
    And clicks on the search button
    Given user click on productLink "iPhone" and navigated to product detail page
    When user click on whishList menu
    And enters the product "Apple Cinema 30" in the search box
    And clicks on the search button
    Given user click on productLink "Apple Cinema 30" and navigated to product detail page
    When user click on whishList menu
    And enters the product "MacBook" in the search box
    And clicks on the search button
    Given user click on productLink "MacBook" and navigated to product detail page
    When user click on whishList menu
    When user click on wishListMenu from mainMenu
    Then Validate the product details of wishList
      | iPhone,product 11,Out Of Stock,$123.20               |
      | Apple Cinema 30",Product 15,In Stock,$110.00 $122.00 |
      | MacBook,Product 16,In Stock,$602.00                  |
      
   @productDetail3
  Scenario Outline: After successful login, validate the review UI tab
    When the user logs in successfully and navigates to the My Account page
    And enters the product "iPhone" in the search box
    And clicks on the search button
    Given user click on productLink "iPhone" and navigated to product detail page
    Then validate the tab heading text
    | Description|
    | Reviews (0)|
    When user click on review tab
    Then validate the yourName text field should have following "priya prasad"
    When user submit rating with any value
    Then validate the error message will be displayed
    
    
    
