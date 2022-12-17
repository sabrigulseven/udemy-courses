package com.godoro.springtemplates;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplateController {
	
	@GetMapping(value = "/template/index")
	public String getIndex(Model model) {
		model.addAttribute("message","Bu bir iletidir");
		return "index";
	}
	
	@GetMapping(value = "/template/location")	
	public String getLocation(Model model) {
		model.addAttribute("message","Bu bir iletidir");
		return "myfolder/LocationPage";
	}
}
