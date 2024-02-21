Feature: appointments and visits for the customer

 Scenario Outline: Add appointment
    on this scenario we will check the success add
    Given "<user>" add "<Time>" and "<Date>"
    When the time and date are valid
    Then  Tell the user "Successful Add"

   
   Examples:
           | user | Time | Date |
           | Ameer |10 am|2022-3-10|
           | Ameer |12 pm|2022-3-10|
           | Ameer |5 pm|2022-3-10|
           | Ameer |1 pm|2022-3-10|
           
 Scenario Outline: Fail appointment already exist
    on this scenario we will check if the appointment is already exist
    Given "<user>" add "<Time>" and "<Date>"
    When the appointment is already exist
    Then Tell the user "Appointment already booked"
   Examples:
           | user | Time | Date |
           | Ameer |8 am|2023-5-14|

 Scenario Outline: Fail Add appointment wrong date
    on this scenario we will check the Fail Add non valid date
    Given "<user>" add "<Time>" and "<Date>"
    When the Date are not Valid
    Then  Tell the user "invalid date"
    Examples:
      | user | Time | Date |
      | Ameer | 10 am | 2022-12-33 |
      | Ameer | 10 am| 2022-33-13 |
      | Ameer | 10 am| 2022-4-53 |
      | Ameer | 10 am| 2022-16-13 |
      | Ameer | 10 am| 2022-1-101 |
      | Ameer | 10 am| 20222-15-152 |
      | Ameer | 10 am| 1500-2-10 |
      | Ameer |10 am|2022-3-0|
      | Ameer |10 am|2022-0-10|

  Scenario Outline:  Fail Add appointment wrong time
    on this scenario we will check the Fail Add non Valid Time
    Given "<user>" add "<Time>" and "<Date>"
    When the Time are not Valid
    Then Tell the user "invalid time"
    Examples:
      | user | Time | Date |
      | Ameer | 25 am| 2022-3-10 |
      | Ameer | -5 am| 2022-3-10 |
      | Ameer | -5 pm| 2022-3-10 |
      | Ameer |  6 pm| 2022-3-10 |
      | Ameer |  6 ps| 2022-3-10 |

  Scenario Outline:: success Delete the appointment
      on this scenario we will check the Delete appointment
    Given The "<user>" enter <number of> existing appointment
    When  the user select the appointment to Delete
    Then Tell the user "Success Delete the appointment"
    Examples:
    	| user |number of|
    	| Ameer| 1 |
    	
  Scenario Outline:: fail Delete the appointment
  on this scenario we will check the Delete non existing appointment
    Given The "<user>" enter <number of> existing appointment
    When  the user select the appointment to Delete
    Then Tell the user "Fail Delete the appointment"
    Examples:
      | user |number of|
      | Ameer| 7 |
      | ahmad| 7 |
      | ahmad| 1 |
    	
    Scenario Outline:: Success update for Appointment
    Given The "<user>" enter <number of> existing appointment
    When the user enter new "<time>" and new "<date>"
    Then  Tell the user "success Update"
    Examples:
    | user |number of| time | date |
    |Ameer | 1 | 10 am|2022-12-22|
    
    Scenario Outline:: Fail update for Appointment
    Given The "<user>" enter <number of> existing appointment
    When the user enter new "<time>" and new "<date>"
    Then  Tell the user "fail update"
    Examples:
    | user |number of| time | date |
    |Ameer | 1 | 10 pm|2022-12-12|
    |Ameer | 1 | 10 am|2022-12-122|
    |Ameer | 1 | 10 am|2022-13-23|
    |Ameer | 1 | 10 pm|2022-13-15|
     