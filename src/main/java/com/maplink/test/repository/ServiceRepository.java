package com.maplink.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maplink.test.domain.Service;


@Repository
public interface ServiceRepository extends JpaRepository<Service, Long>  {
	
	
}