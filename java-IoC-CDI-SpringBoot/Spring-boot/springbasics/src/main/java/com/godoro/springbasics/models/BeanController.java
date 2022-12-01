package com.godoro.springbasics.models;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BeanController {
	@GetMapping("/models/bean")
	public String getProduct(Model model) {
		Product product = new Product(301, "Cep Telefonu", 2520.15);
		model.addAttribute("product", product);
		return "models/BeanPage";
	}
}
