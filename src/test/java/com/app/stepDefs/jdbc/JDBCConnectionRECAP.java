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

public class JDBCConnectionRECAP {
	String oracleConUrl = Config.getPropValue("oracledb.url");
	String oracleUserName = Config.getPropValue("oracledb.user");
	String oraclePassword = Config.getPropValue("oracledb.password");
	Connection connection;
	Statement statement;
	ResultSet resultSet;

	@Test
	public void dbConRecap() throws SQLException {
		connection=DriverManager.getConnection(oracleConUrl, oracleUserName, oraclePassword);
		statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		resultSet=statement.executeQuery("select * from regions");
//		System.out.println(resultSet.getString("region_name"));
		DatabaseMetaData meta=connection.getMetaData();
		System.out.println(meta.getUserName());
		ResultSetMetaData rsMeta=resultSet.getMetaData();
		System.out.println(rsMeta.getColumnName(1));
		System.out.println(rsMeta.getColumnCount());
	}
	
	@Test
	public void recap() throws SQLException {
		
		Connection con=DriverManager.getConnection(oracleConUrl, oracleUserName, oraclePassword);
		Statement statement=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet resultSet=statement.executeQuery("select * from employees");
//		resultSet.last();
		ResultSetMetaData rsMeta=resultSet.getMetaData();
		int p=rsMeta.getColumnCount();
		System.out.println(p);
		resultSet.beforeFirst();
//		System.out.println(resultSet.getRow());
//		System.out.println(resultSet.getString("first_name")+resultSet.getInt("salary")+resultSet.getInt("employee_id"));
		Map<String, Object> map=new HashMap<>();
		while(resultSet.next()) {
			for(int i=1;i<p;i++) {
				map.put(rsMeta.getColumnName(i), resultSet.getObject(i));
//				System.out.println(map.get(i));
			}
		}
		list.add(map);
			for(int i=0;i<list.size();i++) {
				System.out.println(list.get(i).get("FIRST_NAME"));
				System.out.println(list.size());
			}
	}
	List<Map<String, Object>>list=new ArrayList();
}
