Feature: DDT within step testing 
@deve 
Scenario: Testing 
#Given: When I logged into suiteCRM
	And I pass info 
		| prefix | firstName | lastName | phoneNumber | title |
		| Prof. | Junus | Bondero | 773 333 4400 | 007 |
		| Dr. | House | Gred | 772 332 4401 | Brain |
		
		#And I logout from application