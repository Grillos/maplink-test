package com.maplink.test.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.maplink.test.request.ServiceRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Service implements Serializable {
	
	private static final long serialVersionUID = -1330120291666923843L;
	
	public Service(ServiceRequest request) {
		this.code = request.getCode();
		this.description = request.getDescription();
		this.value = request.getValue();
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private Long code;
	
	private String description;
	
	private BigDecimal value;
	
}
