package com.app.stepDefs.api;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.testng.Assert;

import com.app.pages.HRAppPage;
import com.app.pages.HRappSearchPage;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAPIPost {
	RequestSpecification request;
	Response response;
	String url = "http://34.223.219.142:1212/ords/hr/employees/";
	int employeeId;
	Map respMap;
	Map reqMap;
	Map UIEmployeeDataMap;
	HRappSearchPage searchPage = new HRappSearchPage();
	HRAppPage hrApp = new HRAppPage();


	@Given("^Content type and Accept type is JSON$")
	public void content_type_and_Accept_type_is_JSON() {
		request = given().accept(ContentType.JSON).and()
				.contentType(ContentType.JSON);
	}

	@When("^I post a new Employee with \"([^\"]*)\" id$")
	public void i_post_a_new_Employee_with_id(String id) throws Exception {
		if (id.equals("random")) {
			employeeId = new Random().nextInt(99999);
		} else {
			employeeId = Integer.parseInt(id);
		}
		reqMap = new HashMap();
		reqMap.put("employee_id", employeeId);
		reqMap.put("first_name", "Jimmy");
		reqMap.put("last_name", "POI");
		reqMap.put("email", "JimmyPOI" + employeeId);
		reqMap.put("phone_number", "156.753.6544");
		reqMap.put("hire_date", "2003-06-17T04:00:00Z");
		reqMap.put("job_id", "IT_PROG");
		reqMap.put("salary", 1200);
		reqMap.put("commission_pct", null);
		reqMap.put("manager_id", null);
		reqMap.put("department_id", 90);

		response = request.body(reqMap).when().post(url);
	}

	@Then("^Status code should be (\\d+)$")
	public void status_code_should_be(int statusCode) {
		Assert.assertEquals(response.statusCode(), statusCode);
	}

	@Then("^Resonse JSON should contain Employee info$")
	public void resonse_JSON_should_contain_Employee_info() {

		respMap = response.body().as(Map.class);
		// and Response JSON should contain Employee info
		for (Object key : reqMap.keySet()) {
			Assert.assertEquals(respMap.get(key), reqMap.get(key));
			System.out.println(respMap.get(key) + " vs " + reqMap.get(key));
		}

	}

	@When("^I send get request with \"([^\"]*)\" id$")
	public void i_send_get_request_with_id(String id) {
		if (!id.equals("random")) {
			employeeId = Integer.parseInt(id);
		}

		response = given().accept(ContentType.JSON).when().get(url + employeeId);
	}

	@Then("^I should get status code (\\d+)$")
	public void i_should_get_status_code(int statusCode) throws Exception {
		Assert.assertEquals(response.statusCode(), statusCode);
	}

	@Then("^employee JSON Response Data should match the JSON data$")
	public void employee_JSON_Response_Data_should_match_the_JSON_data() {
		respMap = response.body().as(Map.class);
		// and Response JSON should contain Employee info
		for (Object key : reqMap.keySet()) {
			Assert.assertEquals(respMap.get(key), reqMap.get(key));
			System.out.println(respMap.get(key) + " vs " + reqMap.get(key));
		}
	}

	@Then("^Status code is (\\d+)$")
	public void status_code_is(int statusCode){
		Assert.assertEquals(response.statusCode(), statusCode);
	}

	@Then("^Response JSON should contain Employee info$")
	public void response_JSON_should_contain_Employee_info() {
	}

	@Then("^I search for Employee with \"([^\"]*)\" id$")
	public void i_search_for_Employee_with_id(String id) {
		hrApp.queryButton.click();

		if (!id.equals("random")) {
			employeeId = Integer.parseInt(id);
		}
		searchPage.deptIdBox.clear();
		searchPage.deptIdBox.sendKeys(id);
		searchPage.searchButton.click();
	}

	@Then("^UI searh results must match API post employee data$")
	public void ui_searh_results_must_match_API_post_employee_data() {

		UIEmployeeDataMap = new HashMap<>();
		UIEmployeeDataMap.put("employee_id", searchPage.empId.getText());
		UIEmployeeDataMap.put("first_name", searchPage.firsNameBox.getText());
		UIEmployeeDataMap.put("last_name", searchPage.lastNameBox.getAttribute("value"));
		UIEmployeeDataMap.put("email", searchPage.emailBox.getAttribute("value"));
		UIEmployeeDataMap.put("salary", searchPage.salaryBox.getAttribute("value"));
		UIEmployeeDataMap.put("job_id", searchPage.titleBox.getAttribute("value"));
		UIEmployeeDataMap.put("department_id", searchPage.deptIdBox.getText());

		// compare the data against Json data used in POST API / MAP

		for (Object key : UIEmployeeDataMap.keySet()) {
			Assert.assertEquals(UIEmployeeDataMap.get(key), reqMap.get(key));
			System.out.println(UIEmployeeDataMap.get(key) + " vs " + reqMap.get(key));
		}

	}

	@When("^I send a GET request with \"([^\"]*)\" id$")
	public void i_send_a_GET_request_with_id(String arg1)  {
	}

	@When("^employee JSON response Data should match the posted JSON data$")
	public void employee_JSON_response_Data_should_match_the_posted_JSON_data() {
	}

}
