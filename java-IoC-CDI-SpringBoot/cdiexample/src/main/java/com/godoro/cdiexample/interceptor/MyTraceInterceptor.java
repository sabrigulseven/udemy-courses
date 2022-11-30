package com.godoro.cdiexample.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@MyTraceBinding
public class MyTraceInterceptor {
	@AroundInvoke
	public Object handle(InvocationContext context) {
		System.out.println("Yakarılan yöntem: " + context.getMethod().getName());
		Object result = null;
		try {
			result = context.proceed();
			System.out.println("Dönen sonuç: " + result);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
