package com.maplink.test.request;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientRequest {
	    
	@NotBlank(message = "name cannot be empty")
	private String name;
	
	@NotBlank(message = "document cannot be empty")
	private String document;
	
}
