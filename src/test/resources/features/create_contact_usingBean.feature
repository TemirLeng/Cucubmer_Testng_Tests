Feature: Create contacts using Beans/Pojo/Model 
Background: Loggin in the application
	When I logged into suiteCRM 
@regression 
Scenario: Create contact 

	When I save a new contact: 
		|firstName|lastName|department|officePhone|cellPhone|
		|Ahmad 	| Abdu     | Well    | 11111111   | 22222222|
		|Amr	|Ibn Al-As | Governor| 5555555555| 1555111555|
	Then I should see contact information for "Ahmad Abdu" 

@hello
Scenario Outline: Create way more contacts 
	When I save a new contact: 
		|firstName|lastName|department|officePhone|cellPhone|
		|<firstname>| <lastname>  | <department> | <office>  | <phone>|
	Then I should see contact information for "<firstname> <lastname>" 
	Examples: 
		|firstname|lastname|deparment|office|phone|
		|Tutu	| Aaraa		| navy	| 000000    	| 999999999|
		|Amr	|Ibn Al-As | Governor| 5555555555| 1555111555|
		