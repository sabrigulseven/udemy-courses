package com.godoro.springaop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.godoro.springaop.module.sales.SalesService;


@Controller
public class GeneralController {
	@Autowired
	private SalesService salesService;
	
	@GetMapping("aop/something/{in}")
	@ResponseBody
	public String getSales(@PathVariable("in") String input) {
		String output = "-Denetleyici- " + salesService.performSomething(input);
		return output;
	}
	
	@GetMapping("aop/another/{in}")
	@ResponseBody
	public String getAnother(@PathVariable("in") String input) {
		String output = "-Denetleyici- " + salesService.performAnother(input);
		return output;
	}
	
	@GetMapping("aop/handle/{in}")
	@ResponseBody
	public String getHandle(@PathVariable("in") String input) {
		String output = "-Denetleyici- " + salesService.handleSomething(input);
		return output;
	}
	
}
