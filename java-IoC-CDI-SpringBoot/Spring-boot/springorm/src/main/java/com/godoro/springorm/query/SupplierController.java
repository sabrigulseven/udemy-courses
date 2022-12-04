package com.godoro.springorm.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SupplierController {

	@Autowired
	private SupplierRepository supplierRepository;

	// Added to SupplierRepository. So it is not neccessary
	// @Autowired
	// private CustomRepository customRepository;

	@GetMapping("/supplier/generate")
	@ResponseBody
	public String generateSuppliers() {
		for (int i = 0; i < 100; i++) {
			Supplier supplier = new Supplier(0, "Satımcı " + (i + 1), 500 + 25 * i);
			supplierRepository.save(supplier);
		}

		return "Alımcılar oluşturuldu: " + 100;
	}

	@GetMapping("/supplier/findAll")
	@ResponseBody
	public String findSuppliers() {
		Iterable<Supplier> supplierList = supplierRepository.findAll();
		return supplierWriter(supplierList);
	}

	@GetMapping("/supplier/findByName/{name}")
	@ResponseBody
	public String findSuppliersByName(@PathVariable(name = "name") String supplierName) {

		Iterable<Supplier> supplierList = supplierRepository.findSuppliersByName(supplierName);
		return supplierWriter(supplierList);
	}

	@GetMapping("/supplier/findByMinDebit/{debit}")
	@ResponseBody
	public String findSuppliersByByMinDebit(@PathVariable(name = "debit") double totalDebitMin) {

		// Iterable<Supplier> supplierList =
		// customRepository.findSupplierTotalDebitMin(totalDebitMin);
		Iterable<Supplier> supplierList = supplierRepository.findSupplierTotalDebitMin(totalDebitMin);
		return supplierWriter(supplierList);
	}

	private String supplierWriter(Iterable<Supplier> supplierList) {
		StringBuilder stringBuilder = new StringBuilder();
		for (Supplier supplier : supplierList) {
			stringBuilder.append(supplier).append("\n");
		}
		return stringBuilder.toString();
	}
}
