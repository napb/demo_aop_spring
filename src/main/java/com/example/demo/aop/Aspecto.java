package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Aspecto {

	@Before("execution(* com.example.demo.servicio.Servicio.*(..))")
	public void beforeExecution(JoinPoint joinPoint) {

		//System.out.println("beforeExecution() is running!");
		//System.out.println("getName : " + joinPoint.getSignature().getName());
		//System.out.println("******");
	}
	
	@After("execution(* com.example.demo.servicio.Servicio.*(..))")
	public void afterExecution(JoinPoint joinPoint){
		
		//System.out.println("afterExecution() is running!");
		//System.out.println("getName : " + joinPoint.getSignature().getName());
		//System.out.println("******");
	}
	
	@AfterReturning("execution(* com.example.demo.servicio.Servicio.*(..))")
	public void afterReturnExecution(JoinPoint jp){

		//System.out.println("afterReturnExecution() is running!");
		//System.out.println("getName : " + jp.getSignature().getName());
		//System.out.println("******");
	}

	@Around("execution(* com.example.demo.servicio.ServicioImpl.*(*))")
	//@Around("within()")
	public Object arround(ProceedingJoinPoint proceedingJoinPoint) {
		System.out.println("Inicio de metodo: " + proceedingJoinPoint.getSignature().getName());

		Object o = null;

		try{
			o = proceedingJoinPoint.proceed();
			System.out.println(o);
			System.out.println("Salida OK metodo: " + proceedingJoinPoint.getSignature().getName());
		} catch (Throwable t) {
			System.out.println("Exception capturada metodo: " + proceedingJoinPoint.getSignature().getName());
			//throw new RuntimeException("salida exception aspecto");
		}

		return o;
	}


}