package com.maplink.test.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

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
import com.maplink.test.domain.Service;
import com.maplink.test.dto.ClientDto;
import com.maplink.test.dto.ServiceDto;
import com.maplink.test.request.ClientRequest;
import com.maplink.test.request.ServiceRequest;
import com.maplink.test.service.ClientService;
import com.maplink.test.service.ServiceService;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class ServiceControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ServiceService service;
	
	private ServiceDto dto;
	
	private ServiceRequest request;
	
	private Service s;
	
	@BeforeEach
	public void init() {
		dto = buildServiceDto();
		request = buildServiceRequest();
		s = buildService();
	}
	
	@Test
	void shouldReturnServiceById() throws Exception {
		when(service.findById(1L)).thenReturn(dto);
		this.mockMvc.perform(get("/v1/clients/1")).andExpect(status().isOk());
		
	}
	
	@Test
	void shouldCreateService() throws Exception {
		when(service.create(s)).thenReturn(dto);
		this.mockMvc.perform(post("/v1/services").contentType(MediaType.APPLICATION_JSON).content(request.toJson())).andExpect(status().isOk());
		
	}
	
	@Test
	void shouldUpdateService() throws Exception {
		when(service.update(1L, s)).thenReturn(dto);
		this.mockMvc.perform(put("/v1/services/1").contentType(MediaType.APPLICATION_JSON).content(request.toJson())).andExpect(status().isOk());
		
	}
	
	
	private ServiceDto buildServiceDto() {
		return ServiceDto
				.builder()
				.id(1L)
				.code(1L)
				.description("service 01")
				.value(new BigDecimal(100))
				.build();
	}
	
	private ServiceRequest buildServiceRequest() {
		return ServiceRequest
				.builder()
				.code(1L)
				.description("service 01")
				.value(new BigDecimal(100))
				.build();
	}
	
	private Service buildService() {
		return Service
				.builder()
				.id(1L)
				.code(1L)
				.description("service 01")
				.value(new BigDecimal(100))
				.build();
	}
	
}
