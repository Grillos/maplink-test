package com.maplink.test.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.maplink.test.domain.Scheduling;
import com.maplink.test.dto.SchedulingDto;
import com.maplink.test.request.SchedulingHourUpdateRequest;
import com.maplink.test.request.SchedulingRequest;
import com.maplink.test.service.SchedulingService;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class SchedulingControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private SchedulingService service;
	
	private SchedulingDto dto;
	
	private SchedulingRequest request;
	
	private Scheduling client;
	
	private SchedulingHourUpdateRequest schedulingUpdate;
	
	@BeforeEach
	public void init() {
		dto = buildSchedulingDto();
		request = buildSchedulingRequest();
		client = buildScheduling();
		schedulingUpdate = buildSchedulingHourUpdateRequest();
	}
	
	@Test
	void shouldReturnclientById() throws Exception {
		when(service.findById(1L)).thenReturn(dto);
		this.mockMvc.perform(get("/v1/schedulings/1")).andExpect(status().isOk());
		
	}
	
	@Test
	void shouldCreateClient() throws Exception {
		when(service.create(client)).thenReturn(dto);
		this.mockMvc.perform(post("/v1/schedulings").contentType(MediaType.APPLICATION_JSON).content(request.toJson())).andExpect(status().isOk());
		
	}
	
	@Test
	void shouldUpdateClient() throws Exception {
		when(service.updateByHour(1L, schedulingUpdate)).thenReturn(dto);
		this.mockMvc.perform(put("/v1/schedulings/1").contentType(MediaType.APPLICATION_JSON).content(schedulingUpdate.toJson())).andExpect(status().isOk());
		
	}
	
	
	private SchedulingDto buildSchedulingDto() {
		return SchedulingDto
				.builder()
				.id(1L)
				.hour(LocalDateTime.parse("2021-01-01 00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))
				.note("note")
				.build();
	}
	
	private SchedulingRequest buildSchedulingRequest() {
		return SchedulingRequest
				.builder()
				.hour("2021-01-01 00:00")
				.note("note")
				.build();
	}
	
	private Scheduling buildScheduling() {
		return Scheduling
				.builder()
				.id(1L)
				.hour(LocalDateTime.parse("2021-01-01 00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))
				.note("note")
				.build();
	}
	
	private SchedulingHourUpdateRequest buildSchedulingHourUpdateRequest() {
		return SchedulingHourUpdateRequest
				.builder()
				.hour("2021-01-01 00:00")
				.note("note")
				.build();
	}
	
}
