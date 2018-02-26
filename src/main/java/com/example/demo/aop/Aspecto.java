package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Aspecto {

	@Before("execution(* com.example.demo.servicio.Servicio.*(..))")
	public void beforeExecution(JoinPoint joinPoint) {

		System.out.println("beforeExecution() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("******");
	}
	
	@After("execution(* com.example.demo.servicio.Servicio.*(..))")
	public void afterExecution(JoinPoint joinPoint){
		
		System.out.println("afterExecution() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("******");
	}
	
	@AfterReturning("execution(* com.example.demo.servicio.Servicio.*(..))")
	public void afterReturnExecution(JoinPoint jp){

		System.out.println("afterReturnExecution() is running!");
		System.out.println("hijacked : " + jp.getSignature().getName());
		System.out.println("******");
	}
	
}