package com.app.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
@JsonIgnoreProperties(ignoreUnknown = true)
public @Data class  APIday4POJORecapPOST {

	private int region_id;
	private String region_name;
}
