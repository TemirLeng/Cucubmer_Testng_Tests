Feature: Create new contact using data from Excel
Trying to practice utility class usage
Background:
	When I logged into suiteCRM
	@devExcel 
Scenario: Go to create a contact page and create as many contacts as we have in the Excel sheet
	When I create a new contact using data from Excel sheet by "./Test.xlsx" and "Sheet3"
	Then "LastName" and "FirstName" contact should be created
