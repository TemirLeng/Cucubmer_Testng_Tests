Feature: Creating contacts 
Background: Logging in application
When I logged into suiteCRM
Scenario: Create contact using a map 
	When I create a new contact: 
		|first_name | M@M@T|
		|last_name | HighVei|
		|office_phone|800-888-8888|
		|cell_phone| 777-777-7777|
		|prefix|Prof.|
		|title| Junior|
	Then I should see contact information for "John Smith"
	
@creating_contact
Scenario Outline: Create contact using a map
	When I create a new contact:
	|first_name|<f_name>|
	|last_name|<l_name>|
	|cell_phone|<c_phone>|
	|office_phone|<o_phone>|
	|prefix| pre|
	|title|tet|
	Then I should see contact information for "<f_name> <l_name>"
	
	Examples:
	|pre|f_name|l_name|c_phone|o_phone|tet|
	|Prof.|Jacky |Chan  | 888888|9999999|t|
	|Dr. |Bruce | Lee  |777777 |5555555|t|
	