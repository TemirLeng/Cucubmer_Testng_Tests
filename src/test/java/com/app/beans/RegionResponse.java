package com.app.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RegionResponse {

//	private String country_name;
//	private String country_id;
	private int region_id;
	private String region_name;
	private ArrayList<Map<String, String>> links;

	public int getRegion_id() {
		return region_id;
	}

	public void setRegion_id(Integer regionId) {
		this.region_id = regionId;
	}
	
	public void setRegion_name(String region_name) {
		this.region_name=region_name;
	}
	
	public String getRegion_name() {
		return region_name;
	}

	public ArrayList<Map<String,String>>getLinks(){
		return links;
	}
	public void setLinks(ArrayList<Map<String, String>> links) {
		this.links = links;
	}
//
//	public String getCountry_id() {
//		return country_id;
//	}
//
//	public void setCountry_id(String country_id) {
//		this.country_id = country_id;
//	}
//
//	public String getCountry_name() {
//		return country_name;
//	}
//
//	public void setCountry_name(String country_name) {
//		this.country_name = country_name;
//	}
}
