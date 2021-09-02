package com.maplink.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.maplink.test.dto.ServiceDto;
import com.maplink.test.repository.ServiceRepository;

@Service
public class ServiceService {
	
	@Autowired
	private ServiceRepository repository;
	
	public Page<ServiceDto> findAll(Pageable pageable) {		
		Page<com.maplink.test.domain.Service> services = repository.findAll(pageable);
		return services.map(ServiceDto::new);
	}
	
	public ServiceDto findById(Long id) {
		return new ServiceDto(repository.getOne(id));
	}
	
	public ServiceDto create(com.maplink.test.domain.Service service) {
		return new ServiceDto(repository.save(service));
	}
	
	public ServiceDto update(Long id, com.maplink.test.domain.Service service) {
		service.setId(id);
		return new ServiceDto(repository.save(service));
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
