Feature: Testing different responses contains correct currencies respectively

  Scenario: As a user I want to check bingo Jackpots request and verify
    When  I send GET request to list endpoint
    And   I must get back valid status code 200
    Then  I verify amount is not negative