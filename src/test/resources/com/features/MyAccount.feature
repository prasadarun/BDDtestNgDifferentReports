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

  @myaccount1
  Scenario: after successful login validate the list of menus under "My account" in myAccount page
    Given user login sucessfully and navigated to My Account page
    Then following menus should be available under "My Account" header
      | Edit your account information    |
      | Change your password             |
      | Modify your address book entries |
      | Modify your wish list            |
    Then validate that all the submenu links should receive response code 200

  @myaccount1
  Scenario: after successful login validate the footer list menus under "My account" in myAccount page
    Given user login sucessfully and navigated to My Account page
    Then following footer menu list will be displyed under "My Account" header
      | Information      |
      | Customer Service |
      | Extras           |
      | My Account       |

  @myaccount1
  Scenario: after successful login validate the footer  information sublist under "My account" in myAccount page
    Given user login sucessfully and navigated to My Account page
    Then following footer information submenu list will be displyed under "My Account" header
      | About Us             |
      | Delivery Information |
      | Privacy Policy       |
      | Terms & Conditions   |

    Then check all submenu are having response code 200