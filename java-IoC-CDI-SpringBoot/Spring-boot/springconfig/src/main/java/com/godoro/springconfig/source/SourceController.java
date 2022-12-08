package com.godoro.springconfig.source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.godoro.springconfig.basics.bean.MyBean;

@Controller
public class SourceController {
	@Autowired
	private MyBean myBean;

	@Autowired
	private MyBean myAnotherBean;

	@GetMapping("/source/bean")
	@ResponseBody
	public String getBean() {

		return "Çekirdek " + myBean;
	}

	@GetMapping("/source/scope")
	@ResponseBody
	public String getScope() {

		return "Kapsam " + myBean.hashCode() +" ==? "+ myAnotherBean.hashCode();
	}
}
