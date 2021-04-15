Feature: Automation practice test

  Scenario: Add summer dresses to cart
    Given open automation practice site
    And browse to summer dresses
    When Add summer dress from location 1 on page to cart
    And Continue shopping
    And Add summer dress from location 2 on page to cart
    And Continue shopping
    Then cart has 2 dresses
    And proceed to sign in section
    