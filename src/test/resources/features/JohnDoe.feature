#language: no
Feature: Search for Doe

@get
Scenario: 
When I logged into suiteCRM
Then I search for "John Doe"
And verify link for "John Doe" is displayed