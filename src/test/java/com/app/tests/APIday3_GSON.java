package com.app.tests;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.app.utilities.Config;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class APIday3_GSON {

	@Test
	public void testWithJsonToHashMap() {

		Response response = given().accept(ContentType.JSON).when()
				.get(Config.getPropValue("hrapp.baseresturl") + "/employees/120");
		HashMap<String, String> map = response.as(HashMap.class);
//		List<Map<String, String>> list=response.as(ArrayList.class);
//		System.out.println(list.get(0));
		System.out.println(map.keySet());
		System.out.println(map.values());
		Assert.assertEquals(map.get("employee_id"), 120);
	}
	
	@Test
	public void convertJsonToListOfMaps() {
		
		Response response=given().accept(ContentType.JSON).
				when().get(Config.getPropValue("hrapp.baseresturl")+"/departments");
		
//		convert the responsethat contains department information into list of maps
//		List<Map<String, Object>>
		List<Map> listOfMap = response.jsonPath().getList("items",Map.class);
		System.out.println(listOfMap.get(0).get("employee_id"));
		
		//assert that first department name is "Administration"
		Assert.assertEquals(listOfMap.get(0).get("department_name"), "Administration");
	}
}
