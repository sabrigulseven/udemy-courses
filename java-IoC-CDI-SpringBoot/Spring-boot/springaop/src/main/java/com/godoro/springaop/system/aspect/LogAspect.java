package com.godoro.springaop.system.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LogAspect {
	
	@Before("@annotation(com.godoro.springaop.system.aspect.Logged)")
	public void coming(JoinPoint joinPoint) {
		System.out.println("ÖNCE Kütükle");
		System.out.println("[INFO]" + joinPoint.toShortString());
	}	
}
