Feature: Test login feature of the page
Scenario: Test user is able to login with correct username and password
	
	Given I want to test username and password 
	When  I input the value to username and password
	Then I should be logged in to the application