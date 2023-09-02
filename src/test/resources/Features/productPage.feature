Feature: Product Page Functionality

  @UItest1
  Scenario: Successfully checkout product/s

    Given user is in the product Home Page
    When user checkout products
      | Sauce Labs Backpack | Test.allTheThings() T-Shirt (Red) | Sauce Labs Bolt T-Shirt |
    Then user should successfully checkout the products
