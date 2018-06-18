package com.app.tests;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.app.utilities.Config;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class APIday4Recap {

	@Test
	public void postNewReion() {
		Map requestMap=new HashMap<>();
		requestMap.put("region_id", 1241);
		requestMap.put("region_name", "Maaa");
		Response response=given().accept(ContentType.JSON)
				.and().contentType(ContentType.JSON)
				.and().body(requestMap).when().post(Config.getPropValue("hrapp.baseresturl")+"/regions/");
		
		Assert.assertEquals(response.statusCode(), 201);
		System.out.println(response.statusLine());
		response.prettyPrint();
		Map expectedResponse=new HashMap();
		expectedResponse.put(1, "Europe");
		expectedResponse.put(2, "Americas");
		expectedResponse.put(3, "Asia");
		expectedResponse.put(4, "Middle East and Africa");
	}
	@Test
	public void warmup() {
		Response response = given().accept(ContentType.JSON).
				and().contentType(ContentType.JSON).when()
				.get(Config.getPropValue("hrapp.baseresturl") + "/regions");
		JsonPath json = response.jsonPath();
		List<Map>responseList=json.getList("items",Map.class);
		
		Map<Integer, String>expectedList=new HashMap();
		expectedList.put(1, "Europe");
		expectedList.put(2, "Americas");
		expectedList.put(3, "Asia");
		expectedList.put(4, "Middle East and Africa");
		
		for(Integer key:expectedList.keySet()) {
			for(Map resp:responseList) {
				if(resp.get("region_id")==key) {
					Assert.assertEquals(resp.get("region_name"),expectedList.get(key));
				}
			}
		}
	}
	
	@Test
	public void warmUpV2() {
		
		Response response=given().accept(ContentType.JSON)
				.and().params("limit",100)
				.and().contentType(ContentType.JSON)
				.when().get(Config.getPropValue("hrapp.baseresturl")+"/regions");
		
		JsonPath json=response.jsonPath();
		Map<Integer, String>expectedList=new HashMap();
		expectedList.put(1, "Europe");
		expectedList.put(2, "Americas");
		expectedList.put(3, "Asia");
		expectedList.put(4, "Middle East and Africa");
//		expectedList.put(101, "NOT Murodil's Region");
		
		for(int i=0;i<4;i++) {
			if((i+1)==json.getInt("items["+i+"].region_id")){
				Assert.assertEquals(expectedList.get(i+1), json.getString("items["+i+"].region_name"));
			}
		}
	}

	@Test
	public void warmupTask() {
		Response response = given().accept(ContentType.JSON).params("limit", 300).when()
				.get("http://34.223.219.142:1212/ords/hr/regions");
		Assert.assertEquals(response.statusCode(), 200);
		JsonPath json = response.jsonPath();
		json.getString("items[0].region_id");

		List<Map> regions = json.getList("items", Map.class);
		Map<Integer, String> expectedRegions = new HashMap<>();
		expectedRegions.put(1, "Europe");
		expectedRegions.put(2, "Americas");
		expectedRegions.put(3, "Asia");
		expectedRegions.put(4, "Middle East and Africa");

		for (Integer regionId : expectedRegions.keySet()) {
			System.out.println("Looking for region: " + regionId);
			for (Map map : regions) {
				if (map.get("region_id") == regionId) {
					Assert.assertEquals(map.get("region_name"), expectedRegions.get(regionId));
				}
			}
		}

	}

	@Test
	public void version3() {
		Response response = given().accept(ContentType.JSON).when()
				.get(Config.getPropValue("hrapp.baseresturl") + "/regions");

		JsonPath json = response.jsonPath();

		Map<Integer, String> expected = new HashMap<>();
		expected.put(1, "Europe");
		expected.put(2, "Americas");
		expected.put(3, "Asia");
		expected.put(4, "Middle East and Africa");

		for (int i = 0; i < 4; i++) {
			System.out.println(json.getInt("items[" + i + "].region_id"));
			Assert.assertEquals(json.getInt("items[" + i + "].region_id"), i + 1);
			Assert.assertEquals(expected.get(i + 1), json.getString("items[" + i + "].region_name"));

		}
	}

	@Test
	public void version4() {

		Response response = given().accept(ContentType.JSON).when()
				.get(Config.getPropValue("hrapp.baseresturl") + "/regions");
		JsonPath json = response.jsonPath();

		List<Map> data = json.getList("items", Map.class);
		Map<Integer, String> expected = new HashMap<>();
		expected.put(1, "Europe");
		expected.put(2, "Americas");
		expected.put(3, "Asia");
		expected.put(4, "Middle East and Africa");

		for (int i = 0; i < data.size(); i++) {
			Assert.assertEquals(data.get(i).get("region_name"), expected.get(i + 1));
			Assert.assertEquals(data.get(i).get("region_id"), i + 1);
		}

	}
}
