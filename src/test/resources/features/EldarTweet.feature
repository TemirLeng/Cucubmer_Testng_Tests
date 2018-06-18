Feature: Log in and tweet
@tweet
Scenario: Logging in to my account and tweeting a message

Given I log in to my twitter account
When I post a new tweet
Then a new message should be posted
