package com.godoro.springorm.query;


import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class SupplierController {
	@Autowired
	private SupplierRepository supplierRepository;

	@GetMapping("/supplier/generate")
	@ResponseBody
	public String generateSuppliers() {
		for (int i = 0; i < 100; i++) {
			Supplier supplier = new Supplier(0, "Satımcı "+(i+1), 500+25*i);
			supplierRepository.save(supplier);
		}
		
		return "Alımcılar oluşturuldu: " + 100;
	}
	
	@GetMapping("/supplier/findAll")
	@ResponseBody
	public String findSuppliers() {
		StringBuilder stringBuilder = new StringBuilder();
		Iterable<Supplier> supplierList =supplierRepository.findAll();
		for (Supplier supplier : supplierList) {
			stringBuilder.append(supplier).append("\n");
		}
		return stringBuilder.toString();
	}
	
	@GetMapping("/supplier/findByName/{name}")
	@ResponseBody
	public String findSuppliersByName(
			@PathVariable(name="name") String supplierName) {
		
		StringBuilder stringBuilder = new StringBuilder();
		Iterable<Supplier> supplierList =supplierRepository.findSuppliersByName(supplierName);
		for (Supplier supplier : supplierList) {
			stringBuilder.append(supplier).append("\n");
		}
		return stringBuilder.toString();
	}
}
