package com.app.stepDefs;


import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.beans.RecapAPIGitHubPojo;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class RecapAPIGitHub {

	public static void main(String []args) {
		
		String url="https://api.github.com/search/repositories?q=user:";

		Response response=given().accept(ContentType.JSON).contentType(ContentType.JSON)
		.when().get(url+"bonigarcia");
		
		JsonPath json=response.jsonPath();
		int j=1;
		List<Map> ownerList=json.getList("items");
		for(Map p:ownerList) {
			
			System.out.println(p.get("private")+" "+ j++);
		}
		
		RecapAPIGitHubPojo pojo=new RecapAPIGitHubPojo();
		RecapAPIGitHubPojo resp=response.body().as(RecapAPIGitHubPojo.class);
//		System.out.println(resp.getTotal_count());
//		System.out.println(resp.getIncomplete_results());?
				Map map=new HashMap();
				for(int i=0;i<resp.getItems().size();i++) {
					map=new HashMap();
					map=(Map)resp.getItems().get(i).get("owner");
					
//					System.out.println(map.get("login")+" " +(i+1));
				}
	}
	
	
}
