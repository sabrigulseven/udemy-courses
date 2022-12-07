package com.godoro.springcomplex.presentation.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.godoro.springcomplex.bussiness.dto.DepartmentSummary;
import com.godoro.springcomplex.bussiness.dto.EmployeeDetail;
import com.godoro.springcomplex.bussiness.dto.EmployeeSummary;
import com.godoro.springcomplex.bussiness.service.DepartmentService;
import com.godoro.springcomplex.bussiness.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private DepartmentService departmentService;

	@GetMapping(path = { "/employee/edit" })
	public String editEmployee(Model model) {
		EmployeeDetail employee = new EmployeeDetail(0, "", 0.0, 0, "");
		model.addAttribute("employee", employee);
		DepartmentSummary departments = departmentService.list();
		model.addAttribute("departments", departments);

		return "/human/EmployeeEdit";
	}

	@GetMapping(path = { "/employee/edit/{id}" })
	public String editEmployee(Model model, @PathVariable("id") long employeeId) {
		EmployeeDetail employee = employeeService.find(employeeId);
		DepartmentSummary departments = departmentService.list();
		model.addAttribute("employee", employee);
		model.addAttribute("departments", departments);
		return "/human/EmployeeEdit";
	}

	@PostMapping(path = { "/employee/edit", "/employee/edit/{id}" })
	public String editEmployee(Model model, EmployeeDetail employee, BindingResult result) {
		DepartmentSummary departments = departmentService.list();
		model.addAttribute("employee", employee);
		model.addAttribute("departments", departments);

		if (result.hasErrors()) {
			result.addError(new ObjectError("employee", "Biçim yanlış"));
			return "/human/EmployeeEdit";
		}
		employeeService.save(employee);
		model.addAttribute("message", "Başarıyla Eklendi");

		return "/human/EmployeeSuccess";

	}

	@GetMapping("/employee/list")
	public String listEmployee(Model model) {
		EmployeeSummary employeeSumarry = employeeService.list();
		DepartmentSummary departments = departmentService.list();
		model.addAttribute("departments", departments);
		model.addAttribute("employees", employeeSumarry);
		model.addAttribute("message", "Çalışanlar");
		return "/human/EmployeeList";
	}

	@PostMapping("/employee/list")
	public String listEmployeeByDepartment(Model model, EmployeeSummary employee, BindingResult result) {
		if (employee.getDepartmentId() == 0) {
			employee = employeeService.list();
		} else {
			employee = employeeService.listByDepartment(employee.getDepartmentId());
		}
		DepartmentSummary departments = departmentService.list();
		model.addAttribute("departments", departments);
		model.addAttribute("employees", employee);
		model.addAttribute("message", "Çalışanlar");
		return "/human/EmployeeList";
	}

	@GetMapping("/employee/delete/{id}")
	public String deleteEmployee(Model model, @PathVariable("id") long employeeId) {
		employeeService.delete(employeeId);
		model.addAttribute("message", "Ürün Silindi: " + employeeId);
		EmployeeSummary employeeSumarry = employeeService.list();
		model.addAttribute("employees", employeeSumarry);
		return "/human/EmployeeList";
	}
}
