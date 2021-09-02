package com.maplink.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.maplink.test.domain.Client;
import com.maplink.test.dto.ClientDto;
import com.maplink.test.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	public Page<ClientDto> findAll(Pageable pageable) {		
		Page<Client> clients = repository.findAll(pageable);
		return clients.map(ClientDto::new);
	}
	
	public ClientDto findById(Long id) {
		return new ClientDto(repository.getOne(id));
	}
	
	public ClientDto create(Client client) {
		return new ClientDto(repository.save(client));
	}
	
	public ClientDto update(Long id, Client client) {
		client.setId(id);
		return new ClientDto(repository.save(client));
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
