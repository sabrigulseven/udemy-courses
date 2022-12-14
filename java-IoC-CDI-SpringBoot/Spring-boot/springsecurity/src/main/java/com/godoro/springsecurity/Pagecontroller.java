package com.godoro.springsecurity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Pagecontroller {

	@GetMapping(value = { "/", "home" })
	public String getHome() {
		return "public/HomePage";
	}
	@GetMapping(value = "/welcome")
	public String getWelcome() {
		return "private/WelcomePage";
	}

}
