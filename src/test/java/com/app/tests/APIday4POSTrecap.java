package com.app.tests;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.app.beans.APIday4POJORecapPOST;
import com.app.beans.Apiday4POJOr;
import com.app.utilities.Config;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class APIday4POSTrecap {

	@Test
	public void testPojo() {
		APIday4POJORecapPOST post=new APIday4POJORecapPOST();
		post.setRegion_id(13442);
		post.setRegion_name("Ulan's region");
		String url=Config.getPropValue("hrapp.baseresturl")+"/regions/";
		Response response= given().accept(ContentType.JSON)
				.contentType(ContentType.JSON).and().body(post)
				.when().post(url);
		
		Assert.assertEquals(response.statusCode(), 201);
		
		response=given().accept(ContentType.JSON).and()
				.contentType(ContentType.JSON)
				.when().get(Config.getPropValue("hrapp.baseresturl")+"/regions");
		APIday4POJORecapPOST po=response.body().as(APIday4POJORecapPOST.class);
		
	}
	@Test
	public void testRecap() {
		Apiday4POJOr post=new Apiday4POJOr();
		post.setRegion_id(4321);
		post.setRegion_name("Leng");
		String url=Config.getPropValue("hrapp.baseresturl")+"/regions/";
		Response response=given().accept(ContentType.JSON)
				.and().contentType(ContentType.JSON)
				.and().body(post).when().post(url);
		Assert.assertEquals(response.statusCode(), 201);
		
		Apiday4POJOr post1=response.body().as(Apiday4POJOr.class);
		Assert.assertEquals(post.getRegion_id(), post1.getRegion_id());
		Assert.assertEquals(post.getRegion_name(), post1.getRegion_name());
		
	}
	@Test
	public void testDelete() {
		Response response=given().accept(ContentType.JSON)
				.and().contentType(ContentType.JSON)
				.when().delete(Config.getPropValue("hrapp.baseresturl")+"/regions/43212");
		Assert.assertEquals(response.statusCode(),200);
	}
	@Test 
	public void testUpdate() {
		Apiday4POJOr put=new Apiday4POJOr();
		put.setRegion_id(000001);
		put.setRegion_name("new Region");
		Response response=given().accept(ContentType.JSON)
			.and().contentType(ContentType.JSON).and().body(put)
			.when().put(Config.getPropValue("hrapp.baseresturl")+"/regions/");
		Apiday4POJOr post1=response.body().as(Apiday4POJOr.class);
		Assert.assertEquals(put.getRegion_id(), post1.getRegion_id());
	}
	
	
	
}
