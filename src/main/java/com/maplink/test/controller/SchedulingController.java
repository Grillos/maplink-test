package com.maplink.test.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.maplink.test.domain.Scheduling;
import com.maplink.test.dto.SchedulingDto;
import com.maplink.test.request.SchedulingHourUpdateRequest;
import com.maplink.test.request.SchedulingRequest;
import com.maplink.test.service.SchedulingService;
import com.sun.istack.NotNull;

@RestController
@RequestMapping(value = "/v1/schedulings")
public class SchedulingController {

	@Autowired
	private SchedulingService service;
	 
    @GetMapping
    public Page<SchedulingDto> findAll(@PageableDefault(sort = "id", direction = Direction.DESC, page = 0, size = 10) Pageable pageable) {
    	return service.findAll(pageable);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<SchedulingDto> findById(@PathVariable @NotNull Long id) {
    	SchedulingDto dto = service.findById(id);
    	return (dto != null) ? new ResponseEntity<>(dto, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @PostMapping
    public ResponseEntity<SchedulingDto> create(@RequestBody @Valid SchedulingRequest request, UriComponentsBuilder uri) {
    	SchedulingDto dto = service.create(new Scheduling(request));
    	
    	return ResponseEntity.created(
    			uri.path("/v1/schedulings/{id}").buildAndExpand(dto.getId()).toUri()).body(dto);
    }
    
    @PutMapping("/{id}")
    public void updateByHour(@PathVariable Long id, @RequestBody @Valid SchedulingHourUpdateRequest request) {
    	service.updateByHour(id, request);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
    	service.delete(id);
    }
    
}
