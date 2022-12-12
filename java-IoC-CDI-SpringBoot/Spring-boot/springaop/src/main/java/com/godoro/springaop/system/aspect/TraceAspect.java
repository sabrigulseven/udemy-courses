package com.godoro.springaop.system.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class TraceAspect {
	
	@Before("execution(* com.godoro.springaop.module.sales.*.*(..))")
	public void comingAll(JoinPoint joinPoint) {
		System.out.println("ÖNCE tümü");
		System.out.println("Uzun: "+joinPoint.toLongString());
		System.out.println("Kısa: "+joinPoint.toShortString());
		System.out.println();
		for (Object arg : joinPoint.getArgs()) {
			System.out.println(arg+": "+arg.getClass().getSimpleName());
		}
		System.out.println();
	}
	
	@Before("execution(* com.godoro.springaop.module.sales.Sales*.*Something(String))")
	public void comingSomething(JoinPoint joinPoint) {
		System.out.println("ÖNCE bir şey");
	}
	
	@Before("execution(* com.godoro.springaop.module.sales.Sales*.handle*(..))")
	public void comingHandle(JoinPoint joinPoint) {
		System.out.println("ÖNCE kotar");
	}
	
}
