@regression @API
Feature: feature to test Current Weather

  Scenario Outline: Validate Current Forecast
    Given user have Current Weather API access
    When user GET current weather using latitude <lat> and longtitude <lon> state code match <expected_state_code>
    Then Current Weather API response status should be 200

    Examples: 
      | lat       | lon        | expected_state_code |
      | 40.730610 | -73.935242 | NY                  |