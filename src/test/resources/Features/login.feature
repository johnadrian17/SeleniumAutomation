Feature: Price Sorting

  @UItest1
  Scenario: Successfully Sort products from Price Low to High

    Given user is successfully logged in
    When user sort products Price (high to low)
    Then user will see sorted products

  @UItest1
  Scenario: Successful Login with Valid Credentials

    Given user is on login Page
    When user enters username and password
    Then user should see Home page




