package com.app.tests;

import java.util.ArrayList;
import java.util.Map;

public class APIDay4RecapPojoResponse {
	private int region_id;
	private String region_name;
	private ArrayList<Map<String, String>> links;

	public void setLinks() {
		this.links = links;
	}

	public ArrayList getLinks() {
		return links;
	}

	public void setRegion_id(int region_id) {
		this.region_id = region_id;
	}

	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}

	public int getRegion_id() {
		return region_id;
	}

	public String getRegion_name() {
		return region_name;
	}
}
