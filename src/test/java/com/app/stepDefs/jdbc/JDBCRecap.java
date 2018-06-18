package com.app.stepDefs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.app.utilities.Config;

public class JDBCRecap {
Connection connection;
Statement statement;
ResultSet resultSet;

@Test
public void recapConnection() throws SQLException {
	connection=DriverManager.getConnection(Config.getPropValue("oracledb.url"),Config.getPropValue("oracledb.user"),Config.getPropValue("oracledb.password"));
	statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	resultSet=statement.executeQuery("select * from regions");
	
	ResultSetMetaData rsMeta=resultSet.getMetaData();
	System.out.println(rsMeta.getColumnCount());
	System.out.println(rsMeta.getColumnName(1));
}
}
