package com.maplink.test.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ServiceRequest {
	    
	@NotNull(message = "code cannot be null")	
	private Long code;
	
	@NotBlank(message = "description cannot be empty")
	private String description;
	
	@NotNull(message = "value cannot be null")	
	private BigDecimal value;
	
}
