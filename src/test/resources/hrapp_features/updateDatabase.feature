Feature: Update a table in the database

@JDBC
Scenario: Send an Update query
Given user establishes a database connection using JDBC
When user sends a "insert into mountain values(1,'My mountain',8611)" to DB
Then new data should be updated in DB