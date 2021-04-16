Feature: Automation practice test

  Scenario: Add summer dresses to cart and proceed to login
    Given open automation practice site
    And browse to summer dresses
    When Add 1st summer dress to cart
    And Continue shopping
    And Add 2nd summer dress to cart
    And Continue shopping
    Then cart has 2 dresses
    And proceed to sign in section
    