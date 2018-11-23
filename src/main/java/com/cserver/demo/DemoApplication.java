package com.cserver.demo;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;  

@RestController
public class DemoApplication {  
  
//	@Value("${content}")
//	private String name;
	
	@Autowired
	private AllProperties allProperties;
    /**
     * @return
     */
    @RequestMapping(value = "/test/{name}", produces="text/html;charset=UTF-8")
   public  String home(@PathVariable("name") String name) { 
    	
        return "Hello Worldddsadssds!==========="+name;    
    } 
   // @RequestMapping(value = "/test2", produces="text/html;charset=UTF-8")
    @GetMapping(value = "/test2")
   public  String homes(@RequestParam(value="age",required=false, defaultValue="ssss") String age) { 
    	
        return "Hello Worldddsadssds!==========="+age;    
    } 
    
     
}  
