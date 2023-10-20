Feature: Inventory Control
  Scenario: Adding item to cart
    Given User already on the inventory page
    When User choose an item
    Then The item entered to the cart

  Scenario: Removing item from cart
    Given User already on the inventory page
    When User already chosen an item
    And User remove the chosen item
    Then The item removed from the cart