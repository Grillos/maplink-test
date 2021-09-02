package com.maplink.test.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Data
@Builder
@AllArgsConstructor
public class ServiceRequest {
	    
	@NotNull(message = "code cannot be null")	
	private Long code;
	
	@NotBlank(message = "description cannot be empty")
	private String description;
	
	@NotNull(message = "value cannot be null")	
	private BigDecimal value;
	
	public String toJson() {
		try {
			return new ObjectMapper().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			log.error("::: .toJson() - Exception :::::: ", e);
			return null;
		}
	}
}
