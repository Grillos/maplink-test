package com.maplink.test.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.maplink.test.domain.Scheduling;
import com.maplink.test.dto.SchedulingDto;
import com.maplink.test.enumaration.ExceptionEnum;
import com.maplink.test.exception.ErrorResponseException;
import com.maplink.test.exception.Response;
import com.maplink.test.repository.SchedulingRepository;
import com.maplink.test.request.SchedulingHourUpdateRequest;

@Service
public class SchedulingService {
	
	@Autowired
	private SchedulingRepository repository;
	
	public Page<SchedulingDto> findAll(Pageable pageable) {		
		Page<Scheduling> schedulings = repository.findAll(pageable);
		return schedulings.map(SchedulingDto::new);
	}
	
	public SchedulingDto findById(Long id) {
		return new SchedulingDto(repository.findById(id)
				.orElseThrow(() -> new ErrorResponseException(
						Response.builder()
						.code(ExceptionEnum.NOT_FOUND.getId())
						.description(ExceptionEnum.NOT_FOUND.getDescription())
						.message(ExceptionEnum.NOT_FOUND.getDescription()).build(),
				HttpStatus.NOT_FOUND)));
	}
	
	public SchedulingDto create(Scheduling scheduling) {
		return new SchedulingDto(repository.save(scheduling));
	}
	
	public void updateByHour(Long id, SchedulingHourUpdateRequest request) {
		
		Scheduling scheduling = repository.findById(id).orElseThrow(() -> new ErrorResponseException(
				Response.builder()
				.code(ExceptionEnum.NOT_FOUND.getId())
				.description(ExceptionEnum.NOT_FOUND.getDescription())
				.message(ExceptionEnum.NOT_FOUND.getDescription()).build(),
		HttpStatus.NOT_FOUND));
		
		scheduling.setHour(LocalDateTime.parse(request.getHour(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
		scheduling.setNote(request.getNote());
		
		repository.save(scheduling);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
