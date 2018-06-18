package com.app.tests;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.app.beans.Country;
import com.app.beans.CountryResponse;
import com.app.beans.Region;
import com.app.beans.RegionResponse;
import com.app.utilities.Config;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class APIDay4RestAssured {

	String url = "http://34.223.219.142:1212/ords/hr/regions/";
	String requestJson = "{\"region_id\" : 10150,\"region_name\":\"someone's region\"}";

	// @Test
	public void postNewRegion() {

		Map requestMap = new HashMap();
		requestMap.put("region_id", 145111);
		requestMap.put("region_name", "someone'ss region");
		Response response = given().accept(ContentType.JSON).and().contentType(ContentType.JSON).and().body(requestMap)
				.when().post(url);

		System.out.println(response.statusLine());
		response.prettyPrint();
		Assert.assertEquals(response.statusCode(), 201);

		Map responseMap = response.body().as(Map.class);

		Assert.assertEquals(requestMap.get("region_id"), responseMap.get("region_id"));
		Assert.assertEquals(requestMap.get("region_name"), responseMap.get("region_name"));

	}

	@Test
	public void usintPojo() {
		String auth="use";
		RestAssured.authentication;
		Header acceptJson=new Header("Accept","application/json");		

		
	}

	@Test
	public void postUsingPOJO() {

		String url = Config.getPropValue("hrapp.baseresturl") + "/regions/";

		Region region = new Region();
		region.setRegion_id(new Random().nextInt(19999));
		region.setRegion_name("someone's region");

		Response response = given().log().all().accept(ContentType.JSON).and().contentType(ContentType.JSON).and()
				.body(region).when().post(url);

		Assert.assertEquals(response.statusCode(), 201);

		RegionResponse responseRegion = response.body().as(RegionResponse.class);

		// And response body should match request body
		// region id and region name must match
		Assert.assertEquals(responseRegion.getRegion_id(), region.getRegion_id());
		Assert.assertEquals(responseRegion.getRegion_name(), region.getRegion_name());

	}

	@Test
	public void postCountryUsingPojo() {
		String url = Config.getPropValue("hrapp.baseresturl") + "/countries/";

		Country reqCountry = new Country();
		reqCountry.setCountry_id("PW");
		reqCountry.setCountry_name("jerContry");
		reqCountry.setRegion_id(new Random().nextInt(1));

		Response response = given().log().all().accept(ContentType.JSON).and().contentType(ContentType.JSON).and()
				.body(reqCountry).when().post(url);

		assertEquals(response.getStatusCode(), 201);

		CountryResponse resCountry = response.body().as(CountryResponse.class);

		assertEquals(resCountry.getCountry_id(), reqCountry.getCountry_id());
		assertEquals(resCountry.getCountry_name(), reqCountry.getCountry_name());
		assertEquals(resCountry.getRegion_id(), reqCountry.getRegion_id());

	}
}
