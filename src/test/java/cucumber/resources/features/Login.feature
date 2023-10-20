Feature: Log in to the website
  Scenario: Log in with correct credentials
    Given User already on the website's login form
    When User fill username field with correct username
    And  User fill password field with correct password
    And User click login button
    Then User will be directed to Inventory page

  Scenario: Log in with no credentials
    Given User already on the website's login form
    And User click login button
    Then User will be shown error message