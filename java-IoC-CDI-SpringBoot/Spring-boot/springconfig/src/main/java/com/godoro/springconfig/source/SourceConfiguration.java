package com.godoro.springconfig.source;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.godoro.springconfig.basics.bean.MyBean;

@Configuration
public class SourceConfiguration {
	
	@Bean
	public MyBean myBean() {
		MyBean myBean = new MyBean();
		myBean.setMyLong(330);
		myBean.setMyString("godoro");
		myBean.setMyDouble(55.11);
		return myBean;
	}
}
