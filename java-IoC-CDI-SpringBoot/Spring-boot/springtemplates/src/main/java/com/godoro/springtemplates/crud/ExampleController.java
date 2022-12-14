package com.godoro.springtemplates.crud;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ExampleController {
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping(path = { "/example/edit", "/example/edit/{id}" })
	public String editExample(Model model, @PathVariable(name = "id", required = false) Long exampleId) {
		Example example;
		if (exampleId == null) {
			example = new Example(0, "", 0.0);
		} else {
			example = new Example(exampleId, "Örnek Ad1", 12.34);
		}
		model.addAttribute("message", messageSource.getMessage("ExampleEdit.fillForm", null, null));
		model.addAttribute("example", example);
		return "/crud/ExampleEdit";
	}

	@PostMapping(path = { "/example/edit", "/example/edit/{id}" })
	public String editExample(Model model, Example example, BindingResult result) {

		if (result.hasErrors()) {
			result.addError(new ObjectError("example", "Biçimde yanlışlık var"));
			return "/crud/ExampleEdit";
		}

		System.out.println("Saklanıyor " + example.getExampleId() + " " + example.getExampleName() + " "
				+ example.getExampleValue());
		model.addAttribute("message", "Başarıyla Saklandı");
		model.addAttribute("example", example);
		return "/crud/ExampleEdit";

	}

	@GetMapping(value = "/example/list")
	public String listExample(Model model) {
		List<Example> exampleList = new ArrayList<>();
		exampleList.add(new Example(701, "Örnek 1", 700));
		exampleList.add(new Example(702, "Örnek 2", 800));
		exampleList.add(new Example(703, "Örnek 3", 900));
		model.addAttribute("exampleList", exampleList);
		model.addAttribute("message", "Örnek dizelgesi");
		return "/crud/ExampleList";
	}

	@GetMapping(value = "/example/delete/{id}")
	public String deleteExample(@PathVariable("id") long exampleId, Model model) {
		System.out.println("Siliniyor.. " + exampleId);
		List<Example> exampleList = new ArrayList<>();
		exampleList.add(new Example(701, "Örnek 1", 700));
		exampleList.add(new Example(702, "Örnek 2", 800));
		exampleList.add(new Example(703, "Örnek 3", 900));
		model.addAttribute("exampleList", exampleList);
		model.addAttribute("message", "Silindi");
		return "/crud/ExampleList";
	}

	@GetMapping(value = "/example/select")
	public String selectExample(Model model) {
		Example selectedExample = new Example(702, "", 0);
		model.addAttribute("selectedExample", selectedExample);
		model.addAttribute("message", "Seçilen:" + selectedExample);
		List<Example> exampleList = new ArrayList<>();
		exampleList.add(new Example(701, "Örnek 1", 700));
		exampleList.add(new Example(702, "Örnek 2", 800));
		exampleList.add(new Example(703, "Örnek 3", 900));
		model.addAttribute("exampleList", exampleList);
		return "/crud/ExampleSelect";
	}

	@PostMapping(value = "/example/select")
	public String selectExample(Model model, Example selectedExample) {
		System.out.println("Seçilen örnek: "+selectedExample);
		model.addAttribute("selectedExample", selectedExample);
		model.addAttribute("message", "Seçilen:" + selectedExample);
		List<Example> exampleList = new ArrayList<>();
		exampleList.add(new Example(701, "Örnek 1", 700));
		exampleList.add(new Example(702, "Örnek 2", 800));
		exampleList.add(new Example(703, "Örnek 3", 900));
		model.addAttribute("exampleList", exampleList);
		
		return "/crud/ExampleSelect";
	}
}