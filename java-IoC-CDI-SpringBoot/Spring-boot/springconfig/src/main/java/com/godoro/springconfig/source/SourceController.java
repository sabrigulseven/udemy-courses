package com.godoro.springconfig.source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.godoro.springconfig.basics.bean.MyAgent;
import com.godoro.springconfig.basics.bean.MyBean;
import com.godoro.springconfig.basics.bean.MySpec;

@Controller
public class SourceController {
	@Autowired
	private MyBean myBean;

	@Autowired
	private MyBean myAnotherBean;

	@Autowired
	private MyAgent myAgent;
	
	@Autowired
	private	MySpec mySpec;
	
	@GetMapping("/source/bean")
	@ResponseBody
	public String getBean() {

		return "Çekirdek " + myBean;
	}

	@GetMapping("/source/scope")
	@ResponseBody
	public String getScope() {

		return "Kapsam " + myBean.hashCode() + " ==? " + myAnotherBean.hashCode();
	}

	@GetMapping("/source/reference")
	@ResponseBody
	public String getReference() {

		return "Kapsam " + myAgent.getAgentName() + "  " + myAgent.getMyBean().toString() + " / " + myBean.hashCode()
				+ " ==? " + myAgent.getMyBean().hashCode();
	}
	
	@GetMapping("/source/inversion")
	@ResponseBody
	public String getInversion() {

		return "Evirtme >" + mySpec.myMethod("Girdi");
	}
}
