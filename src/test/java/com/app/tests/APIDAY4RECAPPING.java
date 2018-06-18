package com.app.tests;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.app.stepDefs.api.RestAPIPost;
import com.app.utilities.Config;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class APIDAY4RECAPPING {

	@Test
	public void warmUpTask() throws FileNotFoundException {

		Response response = given().accept(ContentType.JSON).and()
				.params("limit",100).contentType(ContentType.JSON).when()
				.get(Config.getPropValue("hrapp.baseresturl") + "/regions/");
		Assert.assertEquals(response.statusCode(), 200);
		JsonPath json = response.jsonPath();
//		List<Map> respMap = response.body().as(List.class);

		List<Map> reMap = json.getList("items", Map.class);
		
		Map<Integer, String> reqMap = new HashMap<>();
		reqMap.put(1, "Europe");
		reqMap.put(2, "Americas");
		reqMap.put(3, "Asia");
		reqMap.put(4, "Middle East and Africa");

		for (Integer key : reqMap.keySet()) {

			for (Map map : reMap) {
				if (map.get("region_id") == reqMap.get(key)) {
					System.out.println("Looking for region: "+key);
					Assert.assertEquals(map.get("region_name"),reqMap.get(key));

				}else {
					System.out.println("failed");
					fail();
				}
			}
		}
		}
		@Test
		public void rep() {
			
		Response response=given().accept(ContentType.JSON)
				.contentType(ContentType.JSON).
				when().get(Config.getPropValue("hrapp.baseresturl")+"/regions/");
		RestAPIPost post=response.body().as(RestAPIPost.class);

		
		}

}
