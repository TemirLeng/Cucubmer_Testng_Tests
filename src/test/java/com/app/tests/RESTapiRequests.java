package com.app.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.app.utilities.Config;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RESTapiRequests {
	/*
	 * When I send a GET request to REST URL
	 * http://34.223.219.142:1212/ords/hr/departments Then response status should be
	 * 200
	 * 
	 */
	@Test
	public void simpleGET() {
		when().get("http://34.223.219.142:1212/ords/hr/departments").then().statusCode(200);
	}

	/*
	 * When I send a GET request to REST URL http://34 Then response status should
	 * be 200 Then I should see JSON Response
	 */

	// @Test
	public void printResponse() {
		when().get("http://34.223.219.142:1212/ords/hr/countries").body().prettyPrint();
	}

	/*
	 * When I send GET request ro REST API URL http:// And Accept type is
	 * "application/json" Then response status code should be 200
	 */
	@Test
	public void getWithHeaders() {
		with().accept(ContentType.JSON) // accept - application/json
				.get("http://34.223.219.142:1212/ords/hr/countries/US").then().statusCode(200);
	}

	/*
	 * When I send a GET request to REST URL:
	 * http://34.223.219.142:1212/ords/hr/employees/1234 Then status code is 404
	 */
	@Test
	public void negativeTest() {
		when().get("http://34.223.219.142:1212/ords/hr/employees/1234");
		// .then().statusCode(404);
		Response response = when().get("http://34.223.219.142:1212/ords/hr/employees/1234");
		Assert.assertEquals(response, 404);
		response.prettyPeek();
	}
	@Test
	public void testAmazon() {
		String str12="J"+"a"+"v"+"a";
		String str="Java";
		String str1="";
		String []st= {"J","a","v","a"};
		for(int i=0;i<st.length-1;i++) {
			str1+=st[i];
		}
		System.out.println(str12==str);
		System.out.println(str12.hashCode());
		System.out.println(str.hashCode());
		System.out.println(str1.hashCode());
		System.out.println(str==str1);
		when().get("http://amazon.com").
		then().statusCode(200);
	}
	
	
}
