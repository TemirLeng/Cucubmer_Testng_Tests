package com.app.stepDefs.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.app.utilities.Config;

public class JDBCConnection {

	String oracleDbUrl = Config.getPropValue("oracledb.url");
	String oracleDbUserName = Config.getPropValue("oracledb.user");
	String oracleDbPassword = Config.getPropValue("oracledb.password");

	@Test(enabled = false)
	public void oracleJDBC() throws SQLException {

		Connection connection = DriverManager.getConnection(oracleDbUrl, oracleDbUserName, oracleDbPassword);
		// Statement statement= connection.createStatement();
		Statement statement = connection.
				createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet resultSet = statement.executeQuery("select * from countries");
		resultSet.next();

		/**
		 * how to find out how many records in the resultSet?
		 */
		resultSet.last();
		int rowCount = resultSet.getRow();
		System.out.println("Number of rows: " + rowCount);

		///////////////////////////////////////////////////////////////////
		 System.out.println(resultSet.getString("country_name"));
		// System.out.println(resultSet.getString("country_id"));
		// resultSet.next();
		// System.out.println(resultSet.getString("country_name"));
		// System.out.println(resultSet.getString("country_id"));
		// System.out.println(resultSet.getFetchSize());

		// for(int i=0; i<resultSet.getFetchSize();i++) {
		// resultSet.next();
		// System.out.println(resultSet.getString("country_name"));
		// }
		// resultSet.next();
		resultSet.beforeFirst();
		while (resultSet.next()) {
			System.out.println(resultSet.getString(1) + "-" + resultSet.getString("country_name") + "-"
					+ resultSet.getInt("region_id"));
		}

		// resultSet.first();
		// resultSet.previous();
		// resultSet.last();
		// System.out.println(resultSet.getRow());
		statement.close();
		connection.close();
	}

	@Test
	public void jdbcMetadata() throws SQLException {
		Connection connection = DriverManager.getConnection(oracleDbUrl, oracleDbUserName, oracleDbPassword);
		Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

		// String sql = "select employee_id, last_name, job_id, salary from employees";
		String sql = "select * from employees";
		ResultSet resultSet = statement.executeQuery(sql);

		// Database meatadata
		DatabaseMetaData dbMetadata = connection.getMetaData();
		
		System.out.println("user name: " + dbMetadata.getUserName());
		System.out.println("Database type: " + dbMetadata.getDatabaseProductName());

		// resultSet metadata

		ResultSetMetaData rsMetadata = resultSet.getMetaData();
		System.out.println("Columns count: " + rsMetadata.getColumnCount());
		System.out.println(rsMetadata.getColumnName(1));

		// resultSet.absolute(4);

		// print all column names using a loop

		for (int i = 1; i <= rsMetadata.getColumnCount(); i++) {
			System.out.println("Column names are: " + rsMetadata.getColumnName(i));
		}

		// Throw resultset into a list of Maps
		// Create a List of Maps

		List<Map<String, Object>> list = new ArrayList();
		ResultSetMetaData rsMdata = resultSet.getMetaData();

		int colCount = rsMdata.getColumnCount();

		while (resultSet.next()) {
			Map<String, Object> rowMap = new HashMap();
			for (int i = 1; i < colCount; i++) {
				rowMap.put(rsMdata.getColumnName(i), resultSet.getObject(i));
			}

			list.add(rowMap);
//			System.out.println(list);

		}
		System.out.println(list.get(0).get("HIRE_DATE"));

		for(int i=0;i<list.size();i++) {
			System.out.println(i+". - "+list.get(i).get("EMPLOYEE_ID"));
		}
		
	}
}
