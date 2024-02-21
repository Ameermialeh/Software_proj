Feature: convert appointment to visit
  mark as visited and add services

  Scenario: user arrives at clinic
    Given the admin "Mosab" is logged in with password "m123"
    And an appointment with the admin is booked
    And admin selects appointment number 1
    When user add service 2
    Then appointment should be converted to visit
    And services 2 should be added to invoice

  Scenario: wrong service number
    Given the admin "Mosab" is logged in with password "m123"
    And an appointment with the admin is booked
    And admin selects appointment number 1
    When user add service 19
    Then show error