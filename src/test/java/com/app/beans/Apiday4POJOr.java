package com.app.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
@JsonIgnoreProperties(ignoreUnknown=true)
public @Data class Apiday4POJOr {

	private String region_name;
	private int region_id;
}
