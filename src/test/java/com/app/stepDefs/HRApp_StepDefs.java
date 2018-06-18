package com.app.stepDefs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.app.pages.HRAppPage;
import com.app.utilities.Config;
import com.app.utilities.DBType;
import com.app.utilities.DBUtility;
import com.app.utilities.GenericMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HRApp_StepDefs {
	private WebDriver driver = GenericMethods.setup();

	private HRAppPage hrAppPage = new HRAppPage();
	private Map<String,String> UIDepartmentData;
	private Map<String,Object> DBDepartmentData=new HashMap();
	@Given("^User is on DeptEmpPage$")
	public void user_is_on_DeptEmpPage() {
		driver.get(Config.getPropValue("hrapp.url"));
	}

	@When("^I search for department id (\\d+)$")
	public void i_search_for_department_id(int deptID) throws InterruptedException {
		int currentDepId=Integer.parseInt(hrAppPage.departmentID.getText());
		
		while(currentDepId != deptID) {
			hrAppPage.nextButton.click();
			Thread.sleep(2000);
			hrAppPage=new HRAppPage();
			currentDepId=Integer.parseInt(hrAppPage.departmentID.getText());
			System.out.println(currentDepId);
		}
		UIDepartmentData=new HashMap();
	//add UI data to hashmap
		UIDepartmentData.put("DAPARTMENT_NAME",hrAppPage.departmentName.getText());
		UIDepartmentData.put("MANAGER_ID",hrAppPage.managerID.getText());
		UIDepartmentData.put("LOCATION_ID",hrAppPage.locationID.getText());
//		UIDepartmentData.put("DEPARTMENT_ID", hrAppPage.departmentID.getText());
		
	}

	@When("^I query database with sql: \"([^\"]*)\"$")
	public void i_query_database_with_sql(String sql) throws Exception {
		DBUtility.establishConnection(DBType.ORACLE);
		List<Map<String,Object>> data=DBUtility.runSQLQuery(sql);
		DBDepartmentData=data.get(0);
		DBUtility.closeConnections();
	}
	
	@When("^User searches for email \"([^\"]*)\" to see firstname and lastname$")
	public void user_searches_for_email_to_see_firstname_and_lastname(String email) throws Exception {
		hrAppPage=new HRAppPage();
		hrAppPage.emailBox.clear();
		hrAppPage.emailBox.sendKeys(email);
		hrAppPage.findButton.click();
		UIDepartmentData=new HashMap();
		UIDepartmentData.put("FIRST_NAME", hrAppPage.firstName.getText());
		UIDepartmentData.put("LAST_NAME", hrAppPage.lastName.getText());
	}
	@Then("^UI data and database data must match$")
	public void ui_data_and_database_data_must_match() throws Exception {
		for(String key:UIDepartmentData.keySet()) {
		Assert.assertEquals(UIDepartmentData.get(key), DBDepartmentData.get(key));
			
		}
	}
	
	@When("^I search for department id (\\d+) and get number of employees$")
	public void i_search_for_department_id_and_get_number_of_employees(int deptID) throws Exception {
	hrAppPage.searchForDepartment(deptID);
	hrAppPage.employeesCount.get(0).click();
	UIDepartmentData=new HashMap();
	UIDepartmentData.put("EMPLOYEES_COUNT", String.valueOf(hrAppPage.employeesCount.size()));
	}

}
