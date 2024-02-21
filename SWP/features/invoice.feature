Feature: invoice
  invoice for services provided

  Scenario: billing
    Given an appointment with id 1 is marked as visited
    And services 1 and 3 are added
    When user selects check out
    Then user must be told "successful checkout"
    And invoice total value should be 1700.0



  Scenario: no visit
    Given an appointment with id 2 is not marked as visited
    When user selects check out
    Then user must be told "cart empty, the user didn't visit"