package com.app.tests;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.app.beans.ApiDay4CountryPojo;
import com.app.beans.ApiDay4CountryPojoResponse;
import com.app.utilities.Config;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class APIDay4Recap1 {
	@Test
	public void postNewRegion() {
		int in = new Random().nextInt(9000);
		String url = Config.getPropValue("hrapp.baseresturl") + "/regions/";
		String requestJson = "{\"region_id\":1565, \"region_name\":\"tete region\"}";
		Map requestMap = new HashMap<>();
		requestMap.put("region_id", in);
		requestMap.put("region_name", "reregio" + in);
		Response response = given().accept(ContentType.JSON).and().contentType(ContentType.JSON).and().body(requestMap)
				.when().post(url);

		System.out.println(response.getStatusLine());
		Assert.assertEquals(response.statusCode(), 201);
		Map responseMap = response.body().as(Map.class);

		assertEquals(requestMap.get("region_id"), responseMap.get("region_id"));
		assertEquals(requestMap.get("region_name"), responseMap.get("region_name"));
	}

	@Test
	public void postUsingPojo1() {
		String url = Config.getPropValue("hrapp.baseresturl") + "/regions/";

		APIday4PojoRecap region = new APIday4PojoRecap();
		region.setRegion_id(new Random().nextInt(99999));
		region.setRegion_name("recre");

		Response response = given().accept(ContentType.JSON).and().contentType(ContentType.JSON).and().body(region)
				.when().post(url);
		assertEquals(response.statusCode(), 201);
		// APIday4PojoRecap responseRegion = response.body().as(APIday4PojoRecap.class);
		APIDay4RecapPojoResponse regionResponse = response.body().as(APIDay4RecapPojoResponse.class);
		assertEquals(regionResponse.getRegion_id(), region.getRegion_id());
		assertEquals(regionResponse.getRegion_name(), region.getRegion_name());

		// 2:44 video
	}

	@Test
	public void practiceScenario() {
		
		ApiDay4CountryPojo countries = new ApiDay4CountryPojo();
		countries.setCountry_id("PZ");
		countries.setCountry_name("Pragwaasdf");
		countries.setRegion_id(new Random().nextInt(99999));
		Response response = given().log().all().
				accept(ContentType.JSON).
				and().contentType(ContentType.JSON).
				and().body(countries).
				when().post(Config.getPropValue("hrapp.baseresturl") + "/countries/");
		Assert.assertEquals(response.statusCode(), 201);

		ApiDay4CountryPojoResponse resp = response.body().as(ApiDay4CountryPojoResponse.class);
		Assert.assertEquals(resp.getCountry_id(), countries.getCountry_id());
		Assert.assertEquals(resp.getCountry_name(), countries.getCountry_name());
		Assert.assertEquals(resp.getRegion_id(), countries.getRegion_id());
	}

}
