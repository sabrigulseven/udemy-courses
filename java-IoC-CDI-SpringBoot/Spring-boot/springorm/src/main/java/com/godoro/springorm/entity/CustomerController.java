package com.godoro.springorm.entity;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping("/customer/persist")
	@ResponseBody
	public String persistCustomer(@RequestParam(name = "name") String customerName,
			@RequestParam(name = "credit") double totalCredit) {

		Customer customer = new Customer(0, customerName, totalCredit);
		customerRepository.save(customer);
		return "Varlık eklendi: " + customer;
	}

	@GetMapping("/customer/find/{id}")
	@ResponseBody
	public String findCustomer(@PathVariable(name = "id") long customerId) {

		Optional<Customer> optional = customerRepository.findById(customerId);
		if (optional.isPresent()) {
			Customer customer = optional.get();
			return "Varlık Bulundu: " + customer;
		} else {
			return "Varlık Bulunamadı: " + customerId;
		}

	}

	@GetMapping("/customer/merge/{id}")
	@ResponseBody
	public String mergeCustomer(
			@PathVariable(name = "id") long customerId,
			@RequestParam(name = "name") String customerName, 
			@RequestParam(name = "credit") double totalCredit) {

		Optional<Customer> optional = customerRepository.findById(customerId);
		if (optional.isPresent()) {
			Customer customer = optional.get();
			customer.setCustomerName(customerName);
			customer.setTotalCredit(totalCredit);
			customerRepository.save(customer);
			return "Varlık güncellendi: " + customer;
		} else {
			return "Varlık Bulunamadı: " + customerId;
		}
	}
	
	@GetMapping("/customer/remove/{id}")
	@ResponseBody
	public String removeCustomer(@PathVariable(name = "id") long customerId) {

		Optional<Customer> optional = customerRepository.findById(customerId);
		if (optional.isPresent()) {
			Customer customer = optional.get();
			customerRepository.delete(customer);
			return "Varlık Silindi: " + customer;
		} else {
			return "Varlık Bulunamadı: " + customerId;
		}

	}
}
