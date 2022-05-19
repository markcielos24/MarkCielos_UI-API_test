@regression @UI
Feature: feature to test New Home Loan (ENQUIRE) functionality

  Scenario Outline: Validate New Home Loan (ENQUIRE) is working
    Given browser is open
    And user is on login page
    When user go to Home loans
    And user click Request a call back
    And user click I need help call me back
    And user click New home loans and next button
    And user select a loan <Topic> and click next button
    Then provide if existing customer <Existing_Customer> and NAB ID <NAB_ID>
    And provide firstname <First_Name>
    And provide lastname <Last_Name>
    And provide state <State>
    And provide phone <Phone>
    And provide email <Email>
		And user take screenshot and close browser

    Examples: 
      | Topic                          | Existing_Customer | NAB_ID | First_Name | Last_Name | State | Phone     | Email                  |
      | Buying a new property          | Yes               |   1234 | Mark       | Cielos    | NSW   | 123456789 | markcielos@test.email  |
#      | Buying a new property          | No                |      0 | Karl       | Thomas    | TAS   | 123456789 | karlthomas@test.email  |
#      | Switching my loan to NAB       | Yes               |   5678 | Harry      | Potter    | WA    | 123456789 | harrypotter@test.email |
#      | First home loan deposit scheme | No                |      0 | Link       | Zelda     | SA    | 123456789 | linkzelda@test.email   |
#      | Family home guarantee          | Yes               |   9012 | Shin       | Ryu       | VIC   | 123456789 | shinryu@test.email     |
