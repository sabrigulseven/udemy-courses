package com.godoro.springbasics.parameter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestController {
	@GetMapping("/parametric/request")
	public String getValue(Model model, @RequestParam(name = "myid") long myId) {

		model.addAttribute("message", "Özdeşlik " + myId);
		return "parametric/RequestPage";
	}

	@GetMapping("/parametric/multiple")
	public String getMultiple(Model model, @RequestParam(name = "mytype") String myType,
			@RequestParam(name = "myid", required = false, defaultValue = "0") long myId) {

		model.addAttribute("message", "Tür: " + myType + " - Özdeşlik: " + myId);
		return "parametric/RequestPage";
	}

}
