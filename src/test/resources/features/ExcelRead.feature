Feature: Create contacts using Excel
Background: Loggin in the application
	When I logged into suiteCRM 
@excel
Scenario: Contact search using Excel sheet
#Then I search for "John Doe"
And I validate contact data from excel sheet using "./Test.xlsx" and  "Sheet1"
#And I try to log out of application