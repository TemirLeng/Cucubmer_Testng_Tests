package com.app.tests;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.RestAssured.with;

import java.net.URI;
import java.net.URISyntaxException;

import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class HRRestAPIGetRequests {

	/**
	 * When I send a Get request to REST URL
	 * http://34.223.219.142:1212/ords/hr/countries Then the response status should
	 * be 200
	 */
	@Test
	public void simpleGet() {
		when().get("http://34.223.219.142:1212/ords/hr/employees").then().statusCode(200);
	}

	/*
	 * When I send a GET request to REST URL
	 * http://34.223.219.142:1212/ords/hr/countries Then response status should be
	 * 200 And I should see JSON Response
	 */
	@Test
	public void printResponse() {
		when().get("http://34.223.219.142:1212/ords/hr/countries").body().prettyPrint();
	}

	/*
	 * When I send a GET request to REST API URL
	 * http://34.223.219.142:1212/ords/hr/countries/US And Accept type is
	 * "application/json" Then response status code should be 200
	 */
	// @Test
	public void getWithHeaders() {
		with().accept(ContentType.JSON). // accept - application/json
				when().get("http://34.223.219.142:1212/ords/hr/countries/US").then().statusCode(200);
	}

	/*
	 * When I send get request to REST API URL
	 * http://34.223.219.142:1212/ords/hr/employees/300 Then response status code
	 * should be 404
	 */
	@Test
	public void negativeTest() {
		// when().get("http://34.223.219.142:1212/ords/hr/employees/300")
		// .then().statusCode(404);
		Response response = when().get("http://34.223.219.142:1212/ords/hr/employees/300");
		Assert.assertEquals(response.statusCode(), 404);
		Assert.assertTrue(response.asString().contains("Not Found"));
		// System.out.println(response.asString());
		// response.prettyPrint();

	}

	/*
	 * 
	 * 
	 * WITH, WHEN, GET, ASSERT THAT, ACCEPT, CONTENTTYPE
	 */
	@Test
	public void VerifyContentTypeWithAsserThat() {
		String url = "http://34.223.219.142:1212/ords/hr/employees/100";
		given().accept(ContentType.JSON).get(url)
		.then().assertThat().statusCode(200)
		.and().contentType(ContentType.XML);
	}

	/*
	 * Given Accept type is JSON 
	 * When I sent a GET request to REST API URL:
	 * http://34.223.219.142:1212/ords/hr/employees/100 
	 * Then status code is 200 And
	 * Response content should be json 
	 * And first name should be "Steven"
	 */
	@Test
	public void VerifyFirstName() throws URISyntaxException {
		URI uri = new URI("http://34.223.219.142:1212/ords/hr/employees/100");
		System.out.println("URI portNumber is: " + uri.getPort());

		given().accept(ContentType.JSON).when().get(uri)
		.then().assertThat().statusCode(200)
		.and().contentType(ContentType.JSON)
		.and().assertThat().body("first_name", Matchers.equalTo("Steven"))
		.and().assertThat().body("employee_id", equalTo(100));
	}
	@Test
	public void VerifyLastName() {
		Response response=given().accept(ContentType.JSON)
		.when().get("http://34.223.219.142:1212/ords/hr/employees/110");
		response.then().assertThat().statusCode(200);
		System.out.println(response.asString());
		
		Assert.assertEquals(response.time(), 833);
		
		
	}
}
