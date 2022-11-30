package com.godoro.cdiexample.interceptor.multiple;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@MyCountBinding(ascending = true)
public class MyCountInterceptorAscending {
	private int count = 10;

	@AroundInvoke
	public Object handle(InvocationContext context) {
		System.out.println("Yakarılan yöntem: " + context.getMethod().getName());
		Object result = null;
		try {
			result = context.proceed();
			count++;
			System.out.println("sayaç: " + count);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
