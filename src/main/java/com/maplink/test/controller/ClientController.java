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

import com.maplink.test.domain.Client;
import com.maplink.test.dto.ClientDto;
import com.maplink.test.request.ClientRequest;
import com.maplink.test.service.ClientService;
import com.sun.istack.NotNull;

@RestController
@RequestMapping(value = "/v1/clients")
public class ClientController {

	@Autowired
	private ClientService service;
	 
    @GetMapping
    public Page<ClientDto> findAll(@PageableDefault(sort = "id", direction = Direction.DESC, page = 0, size = 10) Pageable pageable) {
    	return service.findAll(pageable);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> findById(@PathVariable @NotNull Long id) {
    	ClientDto dto = service.findById(id);
    	return (dto != null) ? new ResponseEntity<>(dto, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @PostMapping
    public ResponseEntity<ClientDto> create(@RequestBody @Valid ClientRequest request, UriComponentsBuilder uri) {
    	ClientDto dto = service.create(new Client(request));
    	
    	return ResponseEntity.created(
    			uri.path("/v1/schedulings/{id}").buildAndExpand(dto.getId()).toUri()).body(dto);
    }
    
    @PutMapping("/{id}")
    public ClientDto update(@PathVariable Long id, @RequestBody @Valid ClientRequest request) {
    	return service.update(id, new Client(request));
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
    	service.delete(id);
    }
    
}
