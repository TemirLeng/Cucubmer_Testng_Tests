Feature: Dashboard Note
@regr
Scenario: Post a note on Dashboard
Given I logged into suiteCRM
When I post "Hello Everyone by Chicago Beasts"
Then "love you Everyone" should be displayed
And I logged out from application