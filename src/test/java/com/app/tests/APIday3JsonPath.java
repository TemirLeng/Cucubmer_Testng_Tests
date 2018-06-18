package com.app.tests;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.app.utilities.Config;

import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class APIday3JsonPath {

	/*
	 * Given Accept type is JSON When I send a GET request to REST url:
	 * http://34.223.219.142:1212/ords/hr/regions Then status code is 200 And
	 * Response content should by JSON And 4 should be returned
	 */
	
	
	@Test
	public void test2() {
		given().accept(ContentType.JSON)
		.and().contentType(ContentType.JSON)
		.and().params("limit",100)
		.and().pathParam("employee_id", 110)
		.when().get(Config.getPropValue("hrapp.baseresturl")+"/employees/{employee_id}")
		.then().statusCode(200).and().body("first_name", Matchers.equalTo("John"))
		.and().body("last_name", Matchers.equalTo("Chen"));
	}
	@Test
	public void test() {
		given().accept(ContentType.JSON).when().get("http://34.223.219.142:1212/ords/hr/regions").then().statusCode(200)
				.and().assertThat().contentType(ContentType.JSON).and().assertThat()
				.body("items.region_name", Matchers.hasItem("Europe")).and().assertThat()
				.body("items.region_name", Matchers.hasItems("Americas", "Asia"));

	}

	// validation of multiple values in response JSON
	@Test
	public void testItemsCountFromResponseBody() {
		given().accept(ContentType.JSON).when().get(Config.getPropValue("hrapp.baseresturl") + "/regions").then()
				.assertThat().statusCode(200).and().assertThat().contentType(ContentType.JSON).and().assertThat()
				.body("items.region_id", Matchers.hasSize(4)).and().assertThat()
				.body("items.region_name", Matchers.hasItem("Americas")).and().assertThat()
				.body("items.region_name", Matchers.hasItems("Americas", "Europe", "Asia"));
	}

	/*
	 * Given Accept type is JSON And Params are limit 100 When I send get REQUEST to
	 * http://34.223.219.142:1212/ords/hr/employees Then status code is 200 And
	 * response content should be JSON And 100 employees data should be in JSON
	 * response body
	 */
	@Test
	public void test1() {
		given().accept(ContentType.JSON).params("limit", 100).when()
				.get(Config.getPropValue("hrapp.baseresturl") + "/employees").then().statusCode(200).and()
				.contentType(ContentType.JSON).and().assertThat().body("items.emplyee_id", Matchers.hasSize(100));
		Workbook workbook=WorkbookFactory.create(file);
	
	
	}

	@Test
	public void testWithQueryParameterAndList() {
		given().accept(ContentType.JSON).and().params("limit", 100).when()
				.get(Config.getPropValue("hrapp.baseresturl") + "/employees").then().statusCode(200).and()
				.contentType(ContentType.JSON).and().assertThat().body("items.employee_id", Matchers.hasSize(100));
	}

	@Test
	public void anotherTest() {
		given().accept(ContentType.JSON).and().params("limit", 100).when()
				.get(Config.getPropValue("hrapp.baseresturl") + "/employees").then().statusCode(200).and()
				.contentType(ContentType.JSON).and().assertThat().body("item.employee_id", Matchers.hasSize(100));
	}

	@Test
	public void anTest() {
		given().accept(ContentType.JSON).pathParam("employee_id", 110).params("limit", 100).when()
				.get(Config.getPropValue("hrapp.baseresturl") + "/employees/{employee_id}").then().statusCode(200).and()
				.contentType(ContentType.JSON).and().assertThat().body("first_name", Matchers.equalTo("John"));
	}

	@Test
	public void reTest() {
		given().accept(ContentType.JSON).pathParam("employee_id", 110).params("limit", 100).when()
				.get(Config.getPropValue("hrapp.baseresturl") + "/employees/{employee_id}").then()
				.contentType(ContentType.JSON).and().statusCode(200).and().assertThat()
				.body("last_name", Matchers.equalTo("Chen"));
	}

	@Test
	public void veTest() {
		given().accept(ContentType.JSON).pathParam("employee_id", 110).params("limit", 100).when()
				.get(Config.getPropValue("hrapp.baseresturl") + "/employees/{employee_id}").then()
				.contentType(ContentType.JSON).and().statusCode(200).and().assertThat()
				.body("last_name", Matchers.equalTo("Chen"));

		Response response = given().accept(ContentType.JSON).pathParam("employee_id", 110).params("limit", 100).when()
				.get(Config.getPropValue("hrapp.baseresturl") + "/employees/{employee_id}");

		JsonPath json = response.jsonPath();
		System.out.println(json.getString("first_name"));
	}
	
	/*
	 * Given Accept type is JSON And Params are limit=100 And path param is 110 When
	 * I send get request to http://34.223.219.142:1212/ords/hr/employee Then status
	 * code id 200 And Response content shloud be JSON And following data should be
	 * returned: "employee_id": 110, "first_name":"John", "last_name":"Chen",
	 * "email":"JCHEN",
	 */

	@Test
	public void testWithQueryParamater() {
		given().accept(ContentType.JSON).and().params("limit", 100).and().pathParams("employee_id", 110).given()
				.accept(ContentType.JSON).and().params("limit", 100).when()
				.get(Config.getPropValue("hrapp.baseresturl") + "/employees/{employee_id}").then().statusCode(200).and()
				.contentType(ContentType.JSON).and().assertThat().body("employee_id", Matchers.equalTo(110),
						"first_name", Matchers.equalTo("John"), "last_name", Matchers.equalTo("Chen"), "email",
						Matchers.equalToIgnoringCase("jchen"));

	}

	/*
	 * Given Accept type is JSON And Params are limit=100 And path param is 110 When
	 * I send get request to http://34.223.219.142:1212/ords/hr/employees Then status
	 * code is 200 And Response content should by json All employee ids should be
	 * returned
	 */
	
	@Test
	public void testJsonPath() {
		
		Map<String, Integer> rParamMap=new HashMap<>();
		rParamMap.put("limit", 100)
		;
		Response response=given().accept(ContentType.JSON).and().params(rParamMap).
				pathParam("employee_id", 177).
	when().get("http://34.223.219.142:1212/ords/hr/employees/{employee_id}");
		JsonPath json=response.jsonPath();
		System.out.println(json.getInt("employee_id"));
		System.out.println(json.getString("first_name"));
		System.out.println(json.getString("last_name"));
		System.out.println(json.getInt("salary"));
		System.out.println(json.getString("links[0].href"));
		List<String> list=json.getList("links.href");
		System.out.println(list.get(3));
	}

	@Test
	public void testWithJsonPath() {
		Map<String, Integer> rParamMap = new HashMap();
		rParamMap.put("limit", 100);

		Response response = given().accept(ContentType.JSON) // header
				.and().params(rParamMap) // query param/request param
				.and().pathParam("employee_id", 177) // path param
				.when().get(Config.getPropValue("hrapp.baseresturl") + "/employees/{employee_id}");

		JsonPath json = response.jsonPath(); // get json body and assign to jsonPath object

		System.out.println(json.getInt("employee_id"));
		System.out.println(json.getString("first_name"));
		System.out.println(json.getString("job_id"));
		System.out.println(json.getInt("salary"));
		System.out.println(json.getString("links[0].href")); // get specific element from the array

		// assign all hrefs into a list of strings
		List<String> hrefs = json.getList("links.href");

	}

	/*
	 * Given Accept type is Json 
	 * And params are limit=100 When I send
	 * When I send get request to 
	 * http://34.223.219.142:1212/ords/hr/employees
	 * Then status code should be 200
	 * And Response content should be json
	 * All employee data should be returned
	 */
	
	
	@Test
	public void testJsonPathList() {
		Map<String, Integer>rParamMap=new HashMap();
		rParamMap.put("limit", 100);
		Response response=given().accept(ContentType.JSON)
				.and().params(rParamMap)
				.when().get("http://34.223.219.142:1212/ords/hr/employees");
		Assert.assertEquals(response.statusCode(), 200);
		JsonPath json=response.jsonPath();
		
		
		//get all employee_ids and assign into arrayList
		List<Integer>idList=json.getList("items.employee_id");
		Assert.assertEquals(idList.size(), 100);
		
		//get all emails and assign into arrayList
		List<String>emailList=json.getList("items.email");
		System.out.println(emailList);
		
		//get employee_ids greater than 150
		
		List<Integer>empId=json.getList("items.findAll{it.employee_id>=150}.employee_id");
		System.out.println(empId);
		
		//get all employee last_name whose salary is more than 700
		List lastName=json.getList("items.findAll{it.salary>7000}.last_name");
		System.out.println(lastName);
	}
	
	
	@Test
	public void testJsonPathWithLists() {
		Map<String, Integer> rParamMap = new HashMap();
		rParamMap.put("limit", 100);

		Response response = given().accept(ContentType.JSON) // header
				.and().params(rParamMap) // query param/request param
				.when().get(Config.getPropValue("hrapp.baseresturl") + "/employees");

		Assert.assertEquals(response.statusCode(), 200);

		// JsonPath json=response.jsonPath(); both of these way are gonna work
		// JsonPath json=new JsonPath(FilePath.json);
		JsonPath json = new JsonPath(response.asString());

		// List of employee_ids

		List<Integer> idList = json.getList("items.employee_id");
		System.out.println(idList);

		// assert that there are 100 emp ids
		Assert.assertTrue(idList.size() == 100);

		// get all emails and assign into arrayList

		List<String> emailList = json.getList("items.email");
		Assert.assertEquals(emailList.size(), 100);

		// get all employee_ids that are greater than 150
		List<String> emp = json.getList("items.findAll{it.employee_id>150}.employee_id");
		System.out.println(emp);
		// List<Integer>empIdList=new ArrayList();
		// for(int e:idList) {
		// if(e>150) {
		// empIdList.add(e);
		//
		// }
		// }
		// System.out.println(empIdList);
		//
		// get all employee last_names, whose salary is more than 7000

		List<String> lastNames = json.getList("items.findAll{it.salary>7000}.last_name");
		System.out.println(lastNames);
		System.out.println("Total names " + lastNames.size());
	}

}
