package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Aspect
@Component
public class Aspecto {
/*
	@Before("execution(* com.example.demo.servicio.*.*(..))")
	public void beforeExecution(JoinPoint joinPoint) {

		System.out.println("beforeExecution() is running!");
		System.out.println("getName : " + joinPoint.getSignature().getName());
		System.out.println("******");
	}

 */
/*
	@After("execution(* com.example.demo.servicio.*.*(..))")
	public void afterExecution(JoinPoint joinPoint){
		
		System.out.println("afterExecution() is running!");
		System.out.println("getName : " + joinPoint.getSignature().getName());
		System.out.println("******");
	}
*/

/*
	@AfterReturning("execution(* com.example.demo.servicio.*.*(..))")
	public void afterReturnExecution(JoinPoint jp){

		System.out.println("afterReturnExecution() is running!");
		System.out.println("getName : " + jp.getSignature().getName());
		System.out.println("******");
	}

	@AfterThrowing("execution(* com.example.demo.servicio.*.*(..))")
	public void afterThrowingExecution(JoinPoint jp){

		System.out.println("afterThrowingExecution() is running!");
		System.out.println("getName : " + jp.getSignature().getName());
		System.out.println("******");
	}

	*/

	@Around("@annotation(Loggeable)")
	public Object arround(ProceedingJoinPoint proceedingJoinPoint) {

		System.out.println("Inicio de metodo: [" + proceedingJoinPoint.getSignature().getName() + "]");
		Object o = null;

		try{
			o = proceedingJoinPoint.proceed();
			System.out.println(o);
			System.out.println("Salida OK metodo: [" + proceedingJoinPoint.getSignature().getName() + "]");
		} catch (Throwable t) {
			System.out.println("Exception capturada metodo: [" + proceedingJoinPoint.getSignature().getName() + "]");
			//throw new RuntimeException("salida exception aspecto");
		}

		return o;
	}


	@Around("@annotation(LoggeableReturn)")
	public Object arroundLoggeableReturn(ProceedingJoinPoint proceedingJoinPoint) {

		Object o = null;

		try {
			o = proceedingJoinPoint.proceed();

			/*
			if(o instanceof Map) {
				System.out.println("es un mapa");
			}else if (o instanceof List) {
				System.out.println("es una lista");
			} else if (o instanceof String) {
				System.out.println("es un sting");
			} else {
				System.out.println("no es ninguno de los anteriores");
			}
			*/

            switchType(o, caze(Map.class, x-> x.size()));

		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}

		return o;
	}

	public static <T> void switchType(Object o, Consumer... a) {
		for (Consumer consumer : a)
			consumer.accept(o);
	}

	public static <T> Consumer caze(Class<T> cls, Consumer<T> c) {
		return obj -> Optional.of(obj).filter(cls::isInstance).map(cls::cast).ifPresent(c);
	}


}