package com.godoro.springbasics.post;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EditingController {
	@GetMapping("/editing/employee")
	public String getEmployee(Model model) {
		Employee employee = new Employee(0, "", 0.0);
		model.addAttribute("employee",employee);	
		return "editing/EmployeeEditor";
	}
	@PostMapping("/editing/employee")
	public String postEmployee(Model model, Employee employee) {
		System.out.println("saklanıyor.. ");
		System.out.println(employee);
		model.addAttribute("employee",employee);	
		return "editing/EmployeeEditor";
	}
}
