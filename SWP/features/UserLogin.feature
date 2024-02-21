Feature: login
	user try to login with username and password
	Background:
	    Given the user is not logged in
	    

	Scenario: user login successfully
		Given user enters "Ameer" and "a123"
		When user try to login
		Then user should be told "login successfully"

	Scenario Outline: user enters wrong username
		Given user enters "<user>" and "<password>"
		When user try to login
		Then user should be told "wrong username"
		Examples:
			| user  | password  |
			| something | m123 |
			| something | a123 |
	
	Scenario Outline: user enters wrong password
	    Given user enters "<user>" and "<password>"
	    When user try to login
	    Then user should be told "wrong password"
		Examples:
			| user | password |
			| Mosab | something|
			| Ameer | something|
	    
	 Scenario: admin login successfully
		Given user enters "Mosab" and "m123"
		When user try to login
		Then user should be told "logged in as admin" 