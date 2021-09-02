package com.maplink.test.request;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Data
@Log4j2
@Builder
@AllArgsConstructor
public class SchedulingHourUpdateRequest {
	    
	@NotBlank(message = "houer cannot be empty")
	private String hour;
	
	@NotBlank(message = "note cannot be empty")
	private String note;
	
	public String toJson() {
		try {
			return new ObjectMapper().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			log.error("::: .toJson() - Exception :::::: ", e);
			return null;
		}
	}
}
