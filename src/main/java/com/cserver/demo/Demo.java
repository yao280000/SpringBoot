package com.cserver.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@SpringApplicationConfiguration
@EnableAutoConfiguration
public class Demo {
	 public static void main(String[] args) {  
	        SpringApplication.run(Demo.class, args);  
	    }
}
