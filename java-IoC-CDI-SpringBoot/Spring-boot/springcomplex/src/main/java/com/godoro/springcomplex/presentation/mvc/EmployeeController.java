package com.godoro.springcomplex.presentation.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.godoro.springcomplex.bussiness.dto.EmployeeDetail;
import com.godoro.springcomplex.bussiness.dto.EmployeeSumarry;
import com.godoro.springcomplex.bussiness.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(path = { "/employee/edit" })
	public String editEmployee(Model model) {
		EmployeeDetail employee = new EmployeeDetail(0, "", 0.0, 0, "");
		model.addAttribute("employee", employee);
		return "/human/EmployeeEdit";
	}

	@GetMapping(path = { "/employee/edit/{id}" })
	public String editEmployee(Model model, @PathVariable("id") long employeeId) {
		EmployeeDetail employee = employeeService.find(employeeId);
		model.addAttribute("employee", employee);
		return "/human/EmployeeEdit";
	}

	@PostMapping(path = { "/employee/edit", "/employee/edit/{id}" })
	public String editEmployee(Model model, EmployeeDetail employee, BindingResult result) {
		employeeService.save(employee);
		if (result.hasErrors()) {
			result.addError(new ObjectError("employee", "Biçim yanlış"));
			return "/human/EmployeeEdit";
		}
		model.addAttribute("message", "Başarıyla Eklendi");
		model.addAttribute("employee", employee);
		return "/human/EmployeeSuccess";

	}

	@GetMapping("/employee/list")
	public String listEmployee(Model model) {
		EmployeeSumarry employeeSumarry = employeeService.list();
		model.addAttribute("employees", employeeSumarry);
		model.addAttribute("message", "Çalışanlar");
		return "/human/EmployeeList";
	}

	@GetMapping("/employee/delete/{id}")
	public String deleteEmployee(Model model, @PathVariable("id") long employeeId) {
		employeeService.delete(employeeId);
		model.addAttribute("message", "Ürün Silindi: " + employeeId);
		EmployeeSumarry employeeSumarry = employeeService.list();
		model.addAttribute("employees", employeeSumarry);
		return "/human/EmployeeList";
	}
}
