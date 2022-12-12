package com.godoro.springaop.system.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Pointcut;


public class CommonPointcuts {
	
	@Pointcut("execution(* com.godoro.springaop.module..*.*(..))")
	public void modulePointcut() {
		
	}	
}
