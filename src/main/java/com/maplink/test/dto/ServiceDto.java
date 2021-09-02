package com.maplink.test.dto;

import java.math.BigDecimal;

import com.maplink.test.domain.Service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ServiceDto {
	
	public ServiceDto() {}
	
	public ServiceDto(Service service) {
		this.id = service.getId();
		this.code = service.getCode();
		this.description = service.getDescription();
		this.value = service.getValue();
	}
	
	private Long id;
	
	private Long code;
	
	private String description;
	
	private BigDecimal value;
		
	
}
