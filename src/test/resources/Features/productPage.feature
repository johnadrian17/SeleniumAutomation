Feature: Product Page Functionality

  @UItest1
  Scenario: Successfully add multiple product in Product Page screen

    Given user is in the product Home Page
    When user add multiple products
      | Sauce Labs Backpack | Test.allTheThings() T-Shirt (Red) | Sauce Labs Bolt T-Shirt |
    Then user should add multiple products to the cart