package com.app.stepDefs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import org.apache.commons.lang3.concurrent.ConcurrentException;
import org.junit.Assert;

import com.app.utilities.Config;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import groovy.lang.Singleton;

public class JDBCUpdateQuery {
	Connection connection;
	Statement statement;
	int resultSet;
	String url=Config.getPropValue("dbUrl");
	String username="hr";
	String password="hr";
	
	@Given("^user establishes a database connection using JDBC$")
	public void user_establishes_a_database_connection_using_JDBC() throws SQLException {
		connection=DriverManager.getConnection(url,username,password);
		statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
	}

	@When("^user sends a \"([^\"]*)\" to DB$")
	public void user_sends_a_to_DB(String sql) throws SQLException  {
		resultSet=statement.executeUpdate(sql);
		statement.execute("commit");

	}

	@Then("^new data should be updated in DB$")
	public void new_data_should_be_updated_in_DB() {
		System.out.println(resultSet);
	}
	
	
}
