package com.cserver.demo.aspect;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.cserver.demo.entity.LoggerInfo;
import com.cserver.demo.repository.LogRepository;

@Aspect
@Component
public class HttpAspect {

	private final  Logger logger=LoggerFactory.getLogger(HttpAspect.class);
	
	@Autowired
	private LogRepository logRepository;
	@Pointcut("execution(public * com.cserver.demo.controlls.StudentControll.*(..))")
	public void log(){
		
	}
	
	
	@Before("log()")
	public void doBefore(JoinPoint joinPoint){
		
		// url
		//method
		//ip
		//类名
		//参数
		ServletRequestAttributes servletAttribute= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		
		HttpServletRequest request=servletAttribute.getRequest();
		
		logger.info("url={}",request.getRequestURL());
		logger.info("method={}",request.getMethod());
		logger.info("ip={}",request.getRemoteAddr()+request.getRemoteHost());
		logger.info("class_name={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
		logger.info("canshu={}",joinPoint.getArgs());
		
		logger.info("开始打印");
		
		
		
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		LoggerInfo logInfo=new LoggerInfo();
		logInfo.setUrl(String.valueOf(request.getRequestURL()));
		logInfo.setTime(sdf.format(new Date()));
		logInfo.setMethod(String.valueOf(request.getMethod()));
		logInfo.setFunctionName(String.valueOf(joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName()));
		logInfo.setIp(String.valueOf(request.getRemoteAddr()));
		logInfo.setArgs(String.valueOf(joinPoint.getArgs()));
		System.out.println("dddddddddd:"+String.valueOf(joinPoint.getArgs()));
		logRepository.save(logInfo);
	}
	
	
	@After("log()")
	public void doAfter(){
		logger.info("结束日志");
	}
	
	@AfterReturning(returning="obj",pointcut="log()")
	public void afterReturning(Object obj){
		logger.info("返回结果={}",obj.toString());
	}
}
