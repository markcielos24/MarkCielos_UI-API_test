@regression @API
Feature: feature to test Current Weather

  Scenario Outline: Validate Current Forecast
    Given user have Daily Forecast API access
    When user GET daily forecast using postal code <postal_code>
    Then Daily Forecast API response status should be 200

    Examples: 
      | postal_code |
      |       28546 |