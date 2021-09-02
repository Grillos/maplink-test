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

import com.maplink.test.domain.Service;
import com.maplink.test.dto.ServiceDto;
import com.maplink.test.request.ServiceRequest;
import com.maplink.test.service.ServiceService;
import com.sun.istack.NotNull;

@RestController
@RequestMapping(value = "/v1/services")
public class ServiceController {

	@Autowired
	private ServiceService service;
	 
    @GetMapping
    public Page<ServiceDto> findAll(@PageableDefault(sort = "id", direction = Direction.DESC, page = 0, size = 10) Pageable pageable) {
    	return service.findAll(pageable);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ServiceDto> findById(@PathVariable @NotNull Long id) {
    	ServiceDto dto = service.findById(id);
    	return (dto != null) ? new ResponseEntity<>(dto, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @PostMapping
    public ResponseEntity<ServiceDto> create(@RequestBody @Valid ServiceRequest request, UriComponentsBuilder uri) {
    	ServiceDto dto = service.create(new Service(request));
    	
    	return ResponseEntity.created(
    			uri.path("/v1/schedulings/{id}").buildAndExpand(dto.getId()).toUri()).body(dto);
    }
    
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody @Valid Service request) {
    	service.update(id, request);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
    	service.delete(id);
    }
    
}
