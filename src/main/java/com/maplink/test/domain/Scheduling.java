package com.maplink.test.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.maplink.test.request.SchedulingRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Scheduling implements Serializable {
	
	private static final long serialVersionUID = -1330120291666923843L;
	
	public Scheduling(SchedulingRequest request) {
		this.hour = LocalDateTime.parse(request.getHour(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		this.note = request.getNote();
		this.client = Client.builder().id(request.getClient()).build();
		this.service = Service.builder().id(request.getService()).build();
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private LocalDateTime hour;
	
	private String note;
	
	@ManyToOne
    @JoinColumn(name = "client_id")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name = "service_id")
	private Service service;
	
}
