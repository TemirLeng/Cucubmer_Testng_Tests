package com.app.tests;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.app.utilities.Config;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class APIday3GsonRecap {

	
	@Test
	public void testWithJsonToHashmap() {
		Response response=given().accept(ContentType.JSON)
		.when().get(Config.getPropValue("hrapp.baseresturl")+"/employees/120");
		Map <String, String>map=response.as(HashMap.class);
		System.out.println(map.keySet());
		System.out.println(map.values());
		
		Assert.assertEquals(map.get("employee_id"),120);
		Assert.assertEquals(map.get("job_id"), "AC_MGR");
		Assert.assertEquals(map.get("last_name"), "Weiss");
	}
	
	@Test
	public void ConverJsonToListOfMaps() {
		Response response=given().accept(ContentType.JSON)
				.when().get(Config.getPropValue("hrapp.baseresturl")+"/departments");
		
		List<Map>listOfMaps=response.jsonPath().getList("items",Map.class);
		
		System.out.println(listOfMaps.get(0));
		
		Assert.assertEquals(listOfMaps.get(0).get("department_name"), "Administration");
	}
}
