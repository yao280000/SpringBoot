package com.cserver.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cserver.demo.entity.Student;
import com.cserver.demo.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	@Transactional
	public void insertSt(){
		Student st1=new Student();
		st1.setAge(14);
		st1.setName("王杰1");
		studentRepository.save(st1);
		
		
		Student st2=new Student();
		st2.setAge(19555);
		st2.setName(null);
		studentRepository.save(st2);
	}
}
