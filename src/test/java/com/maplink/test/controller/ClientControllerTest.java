package com.maplink.test.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.maplink.test.domain.Client;
import com.maplink.test.dto.ClientDto;
import com.maplink.test.request.ClientRequest;
import com.maplink.test.service.ClientService;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class ClientControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ClientService service;
	
	private ClientDto dto;
	
	private ClientRequest request;
	
	private Client client;
	
	@BeforeEach
	public void init() {
		dto = buildClientDto();
		request = buildClientRequest();
		client = buildClient();
	}
	
	@Test
	void shouldReturnclientById() throws Exception {
		when(service.findById(1L)).thenReturn(dto);
		this.mockMvc.perform(get("/v1/clients/1")).andExpect(status().isOk());
		
	}
	
	@Test
	void shouldCreateClient() throws Exception {
		when(service.create(client)).thenReturn(dto);
		this.mockMvc.perform(post("/v1/clients").contentType(MediaType.APPLICATION_JSON).content(request.toJson())).andExpect(status().isOk());
		
	}
	
	@Test
	void shouldUpdateClient() throws Exception {
		when(service.update(1L, client)).thenReturn(dto);
		this.mockMvc.perform(put("/v1/clients/1").contentType(MediaType.APPLICATION_JSON).content(request.toJson())).andExpect(status().isOk());
		
	}
	
	
	private ClientDto buildClientDto() {
		return ClientDto
				.builder()
				.id(1L)
				.name("client 01")
				.document("010203040506")
				.build();
	}
	
	private ClientRequest buildClientRequest() {
		return ClientRequest
				.builder()
				.name("client 01")
				.document("010203040506")
				.build();
	}
	
	private Client buildClient() {
		return Client
				.builder()
				.id(1L)
				.name("client 01")
				.document("010203040506")
				.build();
	}
	
}
