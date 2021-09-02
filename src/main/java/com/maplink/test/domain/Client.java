package com.maplink.test.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.maplink.test.request.ClientRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Client implements Serializable {
	
	private static final long serialVersionUID = -1330120291666923843L;
	
	public Client(ClientRequest request) {
		this.name = request.getName();
		this.document = request.getDocument();
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String name;
	
	private String document;
	
}
