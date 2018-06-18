package com.app.tests;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class APIday5CucumberRestAssured {
	String url = "http://34.223.219.142:1212/ords/hr/employees/";
	int randomID=new Random().nextInt(99999);
	
	@Test
	public void test1() {
		Map reqMap=new HashMap();
		
		reqMap.put("employee_id", randomID);
		reqMap.put("first_name", "Jimmy");
		reqMap.put("last_name", "POI");
		reqMap.put("email", "JimmyPOI"+randomID);
		reqMap.put("phone_number", "156.753.6544");
		reqMap.put("hire_date", "2003-06-17T04:00:00Z");
		reqMap.put("job_id", "IT_PROG");
		reqMap.put("salary", 1200);
		reqMap.put("commission_pct", null);
		reqMap.put("manager_id", null);
		reqMap.put("department_id", 90);
		
		Response response= given().accept(ContentType.JSON)
				.and().contentType(ContentType.JSON)
				.and().body(reqMap)
				.when().post(url);
		
		Assert.assertEquals(response.statusCode(), 201);
		
		Map respMap=response.body().as(Map.class);
		
		//and Response JSON should contain Employee info
		for(Object key: reqMap.keySet()) {
			Assert.assertEquals(respMap.get(key), reqMap.get(key));
			System.out.println(respMap.get(key) + " vs "+reqMap.get(key));
		}
		
		
		response=given().accept(ContentType.JSON)
		.when().get(url+randomID);
		Assert.assertEquals(response.statusCode(), 200);
		respMap=response.body().as(Map.class);
		
		//and Response JSON should contain Employee info
		for(Object key: reqMap.keySet()) {
			Assert.assertEquals(respMap.get(key), reqMap.get(key));
			System.out.println(respMap.get(key) + " vs "+reqMap.get(key));
		}
		
		
//		.then().assertThat().statusCode(200)
//		.and().assertThat().contentType(ContentType.JSON)
//		.and().assertThat().body("last_name", Matchers.equalTo("POI"));
//		
	}

}
