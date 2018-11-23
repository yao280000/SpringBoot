package com.cserver.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cserver.demo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	
     public List<Student> findByAge(Integer age);
}
