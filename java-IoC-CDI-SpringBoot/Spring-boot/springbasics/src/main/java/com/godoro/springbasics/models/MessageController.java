package com.godoro.springbasics.models;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MessageController {
	@GetMapping("/models/message")
	public String getMessage(Model model) {
		model.addAttribute("message","ileti");
		return "models/MessagePage";
	}
}
