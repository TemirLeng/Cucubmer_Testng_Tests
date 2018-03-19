Feature: Dashboard Note
@regression
Scenario: Post a note on Dashboard
Given I logged into suiteCRM
When I post "Hello Everyone"
Then "Hello Everyone" should be displayed
And I logged out from application