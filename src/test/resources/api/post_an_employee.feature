Feature: Employee REST API requests

@ApiPost1
Scenario: Post an Employee method test
Given Content type and Accept type is JSON
When I post a new Employee with "random" id 
Then Status code is 201
And Response JSON should contain Employee info
When I send a GET request with "random" id
And status code is 200
And employee JSON response Data should match the posted JSON data