package com.cserver.demo.handle;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cserver.demo.entity.Result;
import com.cserver.demo.utils.ResultUtil;

@ControllerAdvice
public class ExceptionHandle {

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Result returnHand(Exception e){
	
		System.out.println("yichang");
		return ResultUtil.error(100, e.getMessage());
	}
}
