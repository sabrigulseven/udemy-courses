package com.godoro.springorm.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DerivedController {
	@Autowired
	private DerivedRepository derivedRepository;

	@GetMapping("/supplier/findbynameends/{name}")
	@ResponseBody
	public String findBySupplierNameEnds(@PathVariable("name") String supplierNameStarts) {

		Iterable<Supplier> supplierList = derivedRepository.findBySupplierNameEndsWith(supplierNameStarts);
		return supplierWriter(supplierList);
	}
	
	@GetMapping("/supplier/findbydebitmin/{debit}")
	@ResponseBody
	public String findByDebitMin(@PathVariable("debit") double debitMin) {

		Iterable<Supplier> supplierList = derivedRepository.findByTotalDebitGreaterThanEqual(debitMin);
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
