package com.godoro.springaop.system.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class InterventionAspect {

	@Before("execution(* com.godoro.springaop.module.sales.*.*(..))")
	public void doingAll(JoinPoint joinPoint) throws Throwable {
		System.out.println("YOLKESİCİ..");
		String input = (String) joinPoint.getArgs()[0];
		if (input != null && input.equals("Tehlikeli")) {
			throw new IllegalArgumentException("Bu değer olurlanmadı: " + input);
		}
	}

	@Around("execution(* com.godoro.springaop.module.sales.*.*(..))")
	public Object doingAll(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("DEĞİŞTİRİCİ..");
		Object result = null;
		String input = (String) joinPoint.getArgs()[0];
		if (input.equals("Bozuk")) {
			Object[] args = joinPoint.getArgs();
			args[0] = "Düzeltilmiş";
			result = joinPoint.proceed(args);
		}else {
			result = joinPoint.proceed();
		}
		
		return result;
	}

}
