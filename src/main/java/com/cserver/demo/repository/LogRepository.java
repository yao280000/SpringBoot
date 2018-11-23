package com.cserver.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cserver.demo.entity.LoggerInfo;

public interface LogRepository extends JpaRepository<LoggerInfo, Integer>{
	
}
