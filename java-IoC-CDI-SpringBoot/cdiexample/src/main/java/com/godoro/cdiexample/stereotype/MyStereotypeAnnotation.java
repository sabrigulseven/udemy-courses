package com.godoro.cdiexample.stereotype;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Stereotype;
import javax.inject.Named;

import com.godoro.cdiexample.interceptor.MyTraceBinding;
import com.godoro.cdiexample.interceptor.multiple.MyCountBinding;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Named
@ApplicationScoped
@Stereotype
@MyCountBinding(ascending = false)
@MyTraceBinding
@Target({ TYPE })
@Retention(RUNTIME)
@Documented
public @interface MyStereotypeAnnotation {

}
