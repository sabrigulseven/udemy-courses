package com.godoro.springsecurity;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Pagecontroller {

	@GetMapping(value = { "/", "home" })
	public String getHome() {
		return "public/HomePage";
	}
	@GetMapping(value = "/welcome")
	public String getWelcome(Model model) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		model.addAttribute("username",username);
		return "private/WelcomePage";
	}
	

}
