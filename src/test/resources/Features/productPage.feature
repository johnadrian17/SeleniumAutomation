Feature: Product Page Functionality

  @UItest1
  Scenario: Successfully checkout one product

    Given user is in the product Home Page
    When user checkouts Sauce Labs Backpack products
    Then user should successfully checkout the products

  @UItest1
  Scenario: Successfully checkout multiple products

    Given user is in the product Home Page
    When user checkouts products
      | Sauce Labs Backpack | Test.allTheThings() T-Shirt (Red) | Sauce Labs Bolt T-Shirt |
    Then user should successfully checkout the products
