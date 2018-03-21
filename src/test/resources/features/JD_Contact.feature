Feature: Verifying personal info is available
@dev1
Scenario:
When I logged into suiteCRM
Then I search for "John Doe"
Then I clicked on "John Doe" contact
Then contact name is "John Doe" and email is "johnDoe@example.org"