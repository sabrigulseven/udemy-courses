package com.godoro.springsecurity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthenticationController {

	@GetMapping("/login")
	public String getLogin(@RequestParam(value = "error", required = false) String error,Model model) {
		if (error!=null) {
			model.addAttribute("message", "Kimlik bilgileri yanlış");
		}
		else {
			model.addAttribute("message", "Giriş Yapınız");
		}
		return "custom/LoginPage";
	}

}
