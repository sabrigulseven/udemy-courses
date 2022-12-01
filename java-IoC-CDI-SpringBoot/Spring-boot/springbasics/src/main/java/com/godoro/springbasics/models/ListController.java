package com.godoro.springbasics.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListController {
	@GetMapping("/models/list")
	public String getProducts(Model model) {
		List<Product> products = new ArrayList<>();
		products.add(new Product(301, "Cep Telefonu", 2520.15));
		products.add(new Product(302, "Masaüstü Bilgisayar", 4552.35));
		products.add(new Product(303, "Tablet Bilgisayar", 1678.65));
		model.addAttribute("products", products);
		return "models/ListPage";
	}
}
