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
public class TraceAspect {

	@Before("execution(* com.godoro.springaop.module.sales.*.*(..))")
	public void comingAll(JoinPoint joinPoint) {
		System.out.println("ÖNCE tümü");
		System.out.println("Uzun: " + joinPoint.toLongString());
		System.out.println("Kısa: " + joinPoint.toShortString());

	}

	@Before("execution(* com.godoro.springaop.module.sales.Sales*.*Something(String))")
	public void comingSomething(JoinPoint joinPoint) {
		System.out.println("ÖNCE bir şey");
		System.out.println(joinPoint.getTarget().getClass().getSimpleName());
		System.out.println(joinPoint.getSignature().getName());
		System.out.println();
		for (Object arg : joinPoint.getArgs()) {
			System.out.println(arg + ": " + arg.getClass().getSimpleName());
		}
		System.out.println();
	}

	@Before("execution(* com.godoro.springaop.module.sales.Sales*.handle*(..))")
	public void comingHandle(JoinPoint joinPoint) {
		System.out.println("ÖNCE kotar");
	}

	@Around("execution(* com.godoro.springaop.module.sales.*.*(..))")
	public Object doingAll(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("DOLAYINDA..");
		Object result = joinPoint.proceed();
		return result;
	}

	@After("execution(* com.godoro.springaop.module.sales.*.*(..))")
	public void goingAfter(JoinPoint joinPoint) {
		System.out.println("SONRA");
	}

	@AfterReturning("execution(* com.godoro.springaop.module.sales.*.*(..))")
	public void goingAfterReturning(JoinPoint joinPoint) {
		System.out.println("SONRA Dönüş");
	}

	@AfterThrowing("execution(* com.godoro.springaop.module.sales.*.*(..))")
	public void goingAfterThrowing(JoinPoint joinPoint) {
		System.out.println("SONRA Fırlatma");
	}

}
