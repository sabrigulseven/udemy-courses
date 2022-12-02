package com.godoro.springbasics.parameter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ParametricController {
	@GetMapping("/parametric/value/{myid}")
	public String getValue(Model model, @PathVariable(name = "myid") long myId) {

		model.addAttribute("message", "Özdeşlik " + myId);
		return "parametric/VariablePage";
	}

	@GetMapping({ "/parametric/optional/{myid}", "/parametric/optional" })
	public String getOptional(Model model, 
			@PathVariable(name = "myid" , required = false) Long myId) {//Long class
		if (myId==null) {
			model.addAttribute("message", "Özdeşlik " + 0);
			return "parametric/VariablePage";
		}
		else {
			model.addAttribute("message", "Özdeşlik " + myId);
			return "parametric/VariablePage";
		}
		
	}
}
