package com.godoro.springtemplates.crud;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ExampleController {

	@GetMapping(path = { "/example/edit", "/example/edit/{id}" })
	public String editProduct(Model model, @PathVariable(name = "id", required = false) Long exampleId) {
		Example example;
		if (exampleId == null) {
			example = new Example(0, "", 0.0);
		} else {
			example = new Example(exampleId, "Örnek Ad1", 12.34);
		}
		model.addAttribute("example", example);
		return "/crud/ExampleEdit";
	}

	@PostMapping(path = { "/example/edit", "/example/edit/{id}" })
	public String editProduct(Model model, Example example, BindingResult result) {
		System.out.println("Saklanıyor " + example.getExampleId() + " " + example.getExampleName() + " "
				+ example.getExampleValue());
		model.addAttribute("example", example);
		return "/crud/ExampleEdit";

	}
}