package com.app.tests;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.app.utilities.DBType;
import com.app.utilities.DBUtility;

public class EmployeesDBTest {

	@BeforeClass
	public void setup() throws SQLException {
		DBUtility.establishConnection(DBType.ORACLE);
	}
	
	@AfterClass
	public void tearDown() {
		DBUtility.closeConnections();
	}
	
	@Test
	public void countTest() throws SQLException {
		// Connect to oracle database
		// run following sql query
		// select * from employees where job_id='IT_PROG'
		// more than 0 records should be returned

		int rowsCount = DBUtility.getRowsCount("select * from employees where job_id='IT_PROG'");
		Assert.assertTrue(rowsCount > 0);
	}

	@Test
	public void nameTestById() throws SQLException {
		//connect to oracle database
		//ensure 105 Employee_id is 'David Austin'
	
		List<Map<String, Object>>empData=DBUtility.runSQLQuery("select first_name, last_name from employees WHERE employee_id=105");
		
		Assert.assertEquals(empData.get(0).get("FIRST_NAME"), "David");
		Assert.assertEquals(empData.get(0).get("LAST_NAME"), "Austin");
	}

}
