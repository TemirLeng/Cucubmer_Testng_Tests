Feature: Employee REST API requests

Scenario: Post an employee
Given Content type and Accept type is JSON
When I post a new Employee with "random" id
Then Status code should be 201
And Resonse JSON should contain Employee info
When I send get request with "random" id
Then I should get status code 200
And employee JSON Response Data should match the JSON data


@ApiPost
Scenario:
Given Content type and Accept type is JSON
When I post a new Employee with "random" id
Then Status code should be 201
And Response JSON should contain Employee info
Then I search for Employee with "random" id
And I should get status code 200
And UI searh results must match API post employee data