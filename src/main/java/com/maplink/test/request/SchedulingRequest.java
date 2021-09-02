package com.maplink.test.request;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SchedulingRequest {
	    
	@NotBlank(message = "houer cannot be empty")
	private String hour;
	
	@NotBlank(message = "note cannot be empty")
	private String note;
	
	private Long client;
	
	private Long service;
	
}
