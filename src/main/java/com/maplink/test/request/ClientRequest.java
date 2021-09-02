package com.maplink.test.request;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Data
@Builder
@AllArgsConstructor
@Log4j2
public class ClientRequest {
	    
	@NotBlank(message = "name cannot be empty")
	private String name;
	
	@NotBlank(message = "document cannot be empty")
	private String document;
	
	
	public String toJson() {
		try {
			return new ObjectMapper().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			log.error("::: .toJson() - Exception :::::: ", e);
			return null;
		}
	}
}
