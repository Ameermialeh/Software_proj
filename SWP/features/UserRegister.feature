Feature: Register
  new user wants to create a new account
  Background:
    Given the user is not logged in


  Scenario: user create account successfully
    Given user enters "myName" and "myPassword" and "myEmail@mail" and "myPhone"
    When user try to register
    Then the user should be told "Registration successful"


 Scenario Outline: user enters used username
    Given user enters "<name>" and "myPassword" and "myEmail@mail" and "myPhone"
    When user try to register
    Then the user should be told "used username"
    Examples:
      |name|
      |Ameer|
      |Mosab|

  Scenario Outline: user enters used email
    Given user enters "myName" and "myPassword" and "<email>" and "myPhone"
    When user try to register
    Then the user should be told "used email"
    Examples:
      |email|
      |zayd@gmail.com|
      |mosabdwe@hotmail.com|

  Scenario Outline: user enters used phone
    Given user enters "myName" and "myPassword" and "myEmail@mail" and "<phone>"
    When user try to register
    Then the user should be told "used phone number"
    Examples:
    |phone|
    |0598307602|
    |0599333333|