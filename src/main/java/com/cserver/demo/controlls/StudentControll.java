package com.cserver.demo.controlls;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cserver.demo.aspect.HttpAspect;
import com.cserver.demo.entity.Result;
import com.cserver.demo.entity.Student;
import com.cserver.demo.enums.ResultEnum;
import com.cserver.demo.repository.StudentRepository;
import com.cserver.demo.service.StudentService;
import com.cserver.demo.utils.ResultUtil;

@RestController
public class StudentControll {

	
	private final  Logger logger=LoggerFactory.getLogger(StudentControll.class);
	
	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private StudentService studentSerivce;
	@RequestMapping("/getList")
	public List<Student> getStudentList(){
		List<Student> list=studentRepository.findAll();
		logger.info("获取所有的信息列表");
		return list;
	}
	
	@RequestMapping("/getOne/{id}")
	public Student getStudent(@PathVariable(value="id") Integer id){
		Student  st=studentRepository.findOne(id);
		return st;
	}
	
	/*
	@RequestMapping(value="/saveSt",method=RequestMethod.POST)

	public Student saveStudent(@RequestBody String json
           ){
		System.out.println(json);
		JSONObject s=JSON.parseObject(json);
		s.get("name");
		s.get("age");
		s.get("kiu");
		System.out.println(s.get("name"));
		System.out.println(s.get("age"));
		System.out.println(s.get("kiu")==null);
		Student st=new Student();
		st.setName(s.getString("name"));
		st.setAge(s.getInteger("age"));
		studentRepository.save(st);
		return st;
	}
	*/
	
	@RequestMapping(value="/saveSt",method=RequestMethod.POST)
//	public Student saveStudent(@RequestParam("name") String name,
//			                   @RequestParam("age") Integer age){
	public Result<Student> saveStudent(@Valid Student s,BindingResult bindingResult
           ){
		if(bindingResult.hasErrors()){
//			Result<Student> result=new Result<Student>();
//			result.setCode(1);
//			result.setMsg(bindingResult.getFieldError().getDefaultMessage());
//			result.setData(null);
			return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
		}
		
//		Result<Student> result=new Result<Student>();
		
		Student st=new Student();
		st.setName(s.getName());
		st.setAge(s.getAge());
//		result.setCode(0);
//		result.setMsg("成功");
//		result.setData(studentRepository.save(st));
		logger.info(ResultEnum.UNKNOW_INFO.getMsg());
		logger.info("code={}",ResultEnum.UNKNOW_INFO.getCodes());
		return ResultUtil.success(studentRepository.save(st));
	}
	
	
	
	//@PathVariable(value="id") Integer id,
	@RequestMapping(value="/updateSt",method=RequestMethod.PUT)
	public Student updateSt(@RequestBody String json){
		//System.out.println(json);
		JSONObject s=JSON.parseObject(json);
		Student st=new Student();
//		st.setId(id);
	//	System.out.println(s.getInteger("id"));
		st.setId(s.getInteger("id"));
		st.setName(s.getString("name"));
		st.setAge(s.getInteger("age"));
		studentRepository.save(st);
	
		return st;
	}
	
	
	@RequestMapping(value="/findStByAge/{age}",method=RequestMethod.GET)
	public List<Student> findStByAge(@PathVariable(value="age") Integer age){

		List<Student> st=studentRepository.findByAge(age);
	
		return st;
	}
	
	@RequestMapping(value="/saveSt2",method=RequestMethod.POST)
	public void saveSt2(){
		studentSerivce.insertSt();
	}
}
