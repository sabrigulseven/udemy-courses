package com.godoro.springorm.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping("/customer/persist")
	@ResponseBody
	public String persistCustomer() {
		Customer customer = new Customer(0, "Zekai Tunca", 5321);
		customerRepository.save(customer);
		return "Varlık eklendi: "+customer;
	}
}
