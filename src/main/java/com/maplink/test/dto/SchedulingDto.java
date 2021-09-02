package com.maplink.test.dto;

import java.time.LocalDateTime;

import com.maplink.test.domain.Scheduling;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class SchedulingDto {
	
	public SchedulingDto() {}
	
	public SchedulingDto(Scheduling scheduling) {
		this.id = scheduling.getId();
		this.hour = scheduling.getHour();
		this.note = scheduling.getNote();
	}
	
	private Long id;
	
	private LocalDateTime hour;
	
	private String note;
		
	
}
