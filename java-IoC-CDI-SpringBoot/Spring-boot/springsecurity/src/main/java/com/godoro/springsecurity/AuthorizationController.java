package com.godoro.springsecurity;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthorizationController {
	
	@GetMapping("/high")
	public String getHigh() {
		return "high/HighPage";
	}
	
	@GetMapping("/low")
	public String getLow() {
		return "low/LowPage";
	}
	@GetMapping("/partial")
	public String getPartial() {
		return "partial/PartialPage";
	}
	
	@GetMapping("/currentroles")
	@ResponseBody
	public String getCurrent() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		StringBuilder builder = new StringBuilder(); 
		if (authentication!=null) {
			for(GrantedAuthority authority : authentication.getAuthorities()) {
				builder.append(authority.getAuthority()).append(" ");
			}
			return "Yetkililer: " + builder.toString();
		}
		return "giriş yapılmamış";
	}
}
