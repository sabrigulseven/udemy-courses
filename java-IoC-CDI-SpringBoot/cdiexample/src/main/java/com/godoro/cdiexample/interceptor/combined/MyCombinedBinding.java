package com.godoro.cdiexample.interceptor.combined;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.interceptor.InterceptorBinding;

import com.godoro.cdiexample.interceptor.MyTraceBinding;
import com.godoro.cdiexample.interceptor.multiple.MyCountBinding;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@MyTraceBinding
@MyCountBinding(ascending = true)
@InterceptorBinding
@Inherited
@Target({ TYPE, METHOD })
@Retention(RUNTIME)
@Documented
public @interface MyCombinedBinding {
	boolean ascending();
}
