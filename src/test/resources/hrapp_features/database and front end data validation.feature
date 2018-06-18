Feature: Hr Application data base and UI data verification
Background:
Given User is on DeptEmpPage

Scenario: Department data UI and Database verification

When I search for department id 50
And I query database with sql: "SELECT department_name, manager_id, location_id from departments where department_id=50"
Then UI data and database data must match



Scenario Outline: Fristname and lastname search by email-IO vs DB verification
When User searches for email "<email>" to see firstname and lastname
And I query database with sql: "SELECT first_name, last_name from employees where email='<email>'"
Then UI data and database data must match
Examples:
|email|
|JWHALEN|
|MHARTSTE|
|PFAY|
|GCAMBRAU|
|LDEHAAN|
|WGIETZ|

@data
Scenario Outline: Verify Number of employees for department-UI vs DB verification
	When I search for department id <departmentID> and get number of employees
	And I query database with sql: "SELECT COUNT(*) AS EMPLOYEES_COUNT from employees where department_id='<departmentID>'"
	Then UI data and database data must match
	
	Examples:
	|departmentID|
	|50|
#	|20|
#	|40|
#	|80|
#	|120|
#	|110|

