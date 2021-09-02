package com.maplink.test.dto;

import com.maplink.test.domain.Client;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientDto {
	
	public ClientDto() {}
	
	public ClientDto(Client client) {
		this.id = client.getId();
		this.name = client.getName();
		this.document = client.getDocument();
	}
	
	private Long id;
	
	private String name;
	
	private String document;
		
	
}
