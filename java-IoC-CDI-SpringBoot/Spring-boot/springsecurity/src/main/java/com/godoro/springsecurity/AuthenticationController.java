package com.godoro.springsecurity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@GetMapping("/logout")
	public String getLogout(HttpServletRequest request, HttpServletResponse response) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication!=null) {
			new SecurityContextLogoutHandler()
				.logout(request, response, authentication);
		}
		return "custom/LogoutPage";
	}
	
	@GetMapping("/current")
	@ResponseBody
	public String getCurrent() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication!=null) {
			return authentication.getName();
		}
		return "giriş yapılmamış";
	}

}
