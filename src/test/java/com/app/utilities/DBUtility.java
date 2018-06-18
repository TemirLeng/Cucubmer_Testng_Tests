package com.app.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtility {

	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;

	public static void establishConnection(DBType dbType) throws SQLException {

		switch (dbType) {
		case ORACLE:
			connection = DriverManager.getConnection(Config.getPropValue("oracledb.url"),
					Config.getPropValue("oracledb.user"), Config.getPropValue("oracledb.password"));
			break;
		default:
			connection = null;
		}

	}

	public static List<Map<String, Object>> runSQLQuery(String sql) throws SQLException {
		statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		resultSet = statement.executeQuery(sql);

		List<Map<String, Object>> list = new ArrayList<>();
		ResultSetMetaData rsMdata = resultSet.getMetaData();

		int colCount = rsMdata.getColumnCount();

		while (resultSet.next()) {
			Map<String, Object> rowMap = new HashMap<>();
			for (int i = 1; i <= colCount; i++) {
				rowMap.put(rsMdata.getColumnName(i), resultSet.getObject(i));
			}
			list.add(rowMap);
		}
		
		return list;
	}

	public static int getRowsCount(String sql) {
		int rowsCount = 0;
		try {
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			resultSet = statement.executeQuery(sql);
			resultSet.last();
			rowsCount = resultSet.getRow();
		} catch (Exception e) {
			e.getMessage();
		}
		return rowsCount;
	}

	
	public static void closeConnections() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

}

