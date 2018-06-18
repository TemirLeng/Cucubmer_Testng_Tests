Feature: Create a contact
Background: Login to application
When I logged into suiteCRM

@rev
Scenario Outline: contact creation and validation

And I go to create contact page
And I create new contact using "<prefix>" "<firstName>" "<lastName>" "<phoneNumber>" "<title>"
And I validate new created contact info "<prefix>" "<firstName>" "<lastName>" "<phoneNumber>" "<title>"s
And I search for "<lastName>"
And I validate search result with "<lastName>" "<firstName>"

Examples:

| prefix | firstName | lastName | phoneNumber | title |
| Prof. | Junus | Bondero | 773 333 4400 | 007 |
| Dr. | House | Gred | 772 332 4401 | Brain |


Scenario: Creating "Jonh Doe" contact
Then I search for "John Doe"
When I clicked on "John Doe" contact
And remove duplicate for this contact
Then there should be only 1 "John Doe" in the contact page
