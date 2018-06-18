package com.app.beans;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
@JsonIgnoreProperties(ignoreUnknown=true)
public @Data class RecapAPIGitHubPojo {

	
	private String login;
	private int id;
	private String total_count;
	private String incomplete_results;
	private List<Map> items;
	private Map owner;
		
	
}
