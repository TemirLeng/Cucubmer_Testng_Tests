package com.app.tests;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.codehaus.groovy.ast.expr.PostfixExpression;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.app.beans.APIDAY5RecapEmployee;
import com.app.beans.APIDAY5RecapEmployeeResponse;
import com.app.utilities.Config;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.Lombok;

public class APIDAY5Recap {
	int p=new Random().nextInt(99999);
	int r=new Random().nextInt(99999);
	@Test
	public void recap1() {
		Map req = new HashMap<>();
		req.put("employee_id", r);
		req.put("first_name", "Leng");
		req.put("last_name", "Temir");
		req.put("email", "ANasssshyetrrchubur"+r);
		req.put("phone_number", "456-456-7897");
		req.put("hire_date", "2018-06-17T04:00:00Z");
		req.put("job_id", "AD_PRES");
		req.put("salary", 12500);
		req.put("commission_pct", null);
		req.put("manager_id", 100);
		req.put("department_id", 90);
		
		
		APIDAY5RecapEmployee emp= new APIDAY5RecapEmployee();

	emp.setDepartment_id(90);
emp.setEmployee_id(p);
emp.setLast_name("aff");
emp.setFirst_name("faaa");
emp.setEmail("afffaaa"+p);
emp.setSalary(2040);
emp.setJob_id("AD_PRES");
emp.setCommission_pct(null);
emp.setManager_id(100);
emp.setHire_date("2018-06-17T04:00:00Z");
emp.setPhone_number("456-456-7897");

		Response response = given().log().all().accept(ContentType.JSON).and().
				contentType(ContentType.JSON)
				.and().body(req).when()
				.put(Config.getPropValue("hrapp.baseresturl") + "/employees/");
		
		Assert.assertEquals(response.statusCode(), 201);
		JsonPath json=response.jsonPath();
		
		APIDAY5RecapEmployeeResponse empResp=response.body().as(APIDAY5RecapEmployeeResponse.class);
		
		
		/**
		 * Assertion using JSON PATH
		 */
//		Assert.assertEquals(json.getString("first_name"), "chuburbulik");
		
		/**
		 * Assertion using POJO
		 */
//		Assert.assertEquals(emp.getFirst_name(), empResp.getFirst_name());
//		Assert.assertEquals(emp.getEmail(), empResp.getEmail());
		/**
		 * Assertion using Map
		 */
		Map postResEmp=response.body().as(Map.class);
		
		for(Object key:req.keySet()) {
			assertEquals(postResEmp.get(key),req.get(key));
			System.out.println();
		}
		
		
		/**
		 * When I send GET request with our emp_id
		 * Then Status code should be 200
		 * And employee response data should match posted data
		 */
		
		response=given().accept(ContentType.JSON)
				.when().get(Config.getPropValue("hrapp.baseresturl") + "/employees/"+p);
		
		Assert.assertEquals(response.statusCode(), 200);
		APIDAY5RecapEmployeeResponse empResp1=response.body().as(APIDAY5RecapEmployeeResponse.class);
		Assert.assertEquals(emp.getFirst_name(), empResp1.getFirst_name());
		Lombok loom=new Lombok();
		
	}
}
