package com.godoro.springconfig.basics.source;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.godoro.springconfig.basics.bean.MyAgent;
import com.godoro.springconfig.basics.bean.MyBean;
import com.godoro.springconfig.basics.bean.MySpec;
import com.godoro.springconfig.basics.bean.MySpecImpl;

@Configuration
public class SourceConfiguration {

	@Bean(initMethod = "initializeBean", destroyMethod = "finalizeBean")
	@Scope("prototype")
	public MyBean myBean() {
		MyBean myBean = new MyBean();
		myBean.setMyLong(330);
		myBean.setMyString("godoro");
		myBean.setMyDouble(55.11);
		return myBean;
	}
	
	@Bean()
	public MyAgent myAgent() {
		MyAgent myAgent = new MyAgent();
		myAgent.setAgentName("Agent");
		myAgent.setMyBean(myBean());
		return myAgent;
	}
	
	@Bean()
	public MySpec mySpec() {
		MySpec myspec = new MySpecImpl();
		return myspec;
	}
}
