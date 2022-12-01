package com.godoro.springbasics.views;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShowController {
	@GetMapping("/show")
	public String getTest() {
		return "ShowPage.jsp";
	}
	@GetMapping("/indirect")
	public String getIndirect() {
		return "IndirectPage";
	}
	@GetMapping("/below/under")
	public String getUnder() {
		return "below/UnderPage";
	}
}
