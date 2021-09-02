package com.maplink.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maplink.test.domain.Scheduling;


@Repository
public interface SchedulingRepository extends JpaRepository<Scheduling, Long>  {
	
	
}