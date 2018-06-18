package com.app.beans;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.testng.annotations.Test;

import com.app.utilities.Config;

import io.restassured.http.ContentType;

public class ChangeEmail {
	String url = Config.getPropValue("baseresturl") + "/employees/";
	String user = "hr";
	String pass = "hr";

	@Test
	public void jdbcTest() throws SQLException {
		Map map = new HashMap();
		map.put("email", "email" + new Random().nextInt(99999));
		given().accept(ContentType.JSON).and().contentType(ContentType.JSON)
		.pathParams("employee_id","60029").when()
				.put(url, map);

	}
}
