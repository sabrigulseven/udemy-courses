package com.godoro.springaop.system.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class ObservationAspect {

	@Before("execution(* com.godoro.springaop.module..*.*(..))")
	public void coming(JoinPoint joinPoint) {
		System.out.println("ÖNCE Gözle");
	}	
	
	@Around("com.godoro.springaop.system.aspect.CommonPointcuts.modulePointcut()")
	public Object doing(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("DOLAYINDA Gözle");
		Object result = joinPoint.proceed();
		return result;
	}
	
	@After("com.godoro.springaop.system.aspect.CommonPointcuts.modulePointcut()")
	public void going(JoinPoint joinPoint) {
		System.out.println("SONRA Gözle");
	}	
}
