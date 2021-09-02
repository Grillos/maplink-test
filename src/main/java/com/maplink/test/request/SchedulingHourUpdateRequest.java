package com.maplink.test.request;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SchedulingHourUpdateRequest {
	    
	@NotBlank(message = "houer cannot be empty")
	private String hour;
	
	@NotBlank(message = "note cannot be empty")
	private String note;
	
}
