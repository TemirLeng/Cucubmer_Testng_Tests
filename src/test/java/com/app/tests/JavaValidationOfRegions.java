package com.app.tests;

import static io.restassured.RestAssured.given;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import com.app.utilities.Config;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JavaValidationOfRegions {

	@Test
	public void testRegion() {

		
		
		//Store into jsonpath List<map>
		
		
		List<String> testingData=Arrays.asList("1 Europe", "2 Americas","2 Asia","4 Middle East and Africa");
		String url=Config.getPropValue("hrapp.baseresturl")+"/regions";
		
		Response response=given().accept(ContentType.JSON
				).and().params("limit",10).when().get(url);
		JsonPath json=response.jsonPath();
	}
	
	@Test
	public void warmUp() {
		
	}
}
