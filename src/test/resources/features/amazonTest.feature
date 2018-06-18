#language=no
@smoke
Feature: Amazon home page

Scenario:
When user navigates to amazon.com
And searches for "Samsung"
Then "Samsung" related results should be displayed

Scenario:
When user clicks on "Samsung" link
Then "browser" should navigate to "Samsung" related page