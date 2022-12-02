package com.godoro.springbasics.post;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ValidationController {
	@GetMapping("/validating/employee")
	public String getEmployee(Model model) {
		Employee employee = new Employee(0, "", 0.0);
		model.addAttribute("employee", employee);
		return "editing/EmployeeForm";
	}

	@PostMapping("/validating/employee")
	public String postEmployee(Model model, Employee employee, BindingResult result) {
		model.addAttribute("employee", employee);

		if (result.hasErrors()) {

			model.addAttribute("message", "Başarıyla saklandı");
			return "editing/EmployeeForm";

		}
		if (employee.getEmployeeName().length() < 3) {
			result.addError(new ObjectError(
					"employee", "Biçimde bir takım yanlışlıklar var"));
			result.addError(new FieldError(
					"employee", "employeeName", "Çalışan adı en az 3 karakterli olmalıdır"));

			return "editing/EmployeeForm";
		}

		System.out.println("saklanıyor.. ");
		System.out.println(employee);
		return "editing/EmployeeSuccess";
	}
}
