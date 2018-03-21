Feature: Manipulate Contact
@Manip
Scenario:
Given I logged into suiteCRM
Then I search for "John Doe"
When I clicked on "John Doe" contact
And remove duplicate for this contact
Then there should be only 1 "John Doe" in the contact page