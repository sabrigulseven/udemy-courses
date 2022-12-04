package com.godoro.springorm.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ParticularController {
	@Autowired
	private ParticularRepository particularRepository;

	@GetMapping("/supplier/page")
	@ResponseBody
	public String findPageSuppliers() {

		Page<Supplier> supplierList = particularRepository.findAll(PageRequest.of(3, 15));
		return supplierWriter(supplierList);
	}

	@GetMapping("/supplier/sort")
	@ResponseBody
	public String findSortedSuppliers() {

		Iterable<Supplier> supplierList = particularRepository.findAll(Sort.by("totalDebit").descending());
		return supplierWriter(supplierList);
	}

	@GetMapping("/supplier/pagesort")
	@ResponseBody
	public String findPageSortedSuppliers() {

		Page<Supplier> supplierList = particularRepository
				.findAll(PageRequest.of(3, 15, Sort.by("totalDebit").descending()));
		return supplierWriter(supplierList);
	}

	@GetMapping("/supplier/pagebydebit/{debit}")
	@ResponseBody
	public String findPageByMinDebitSuppliers(@PathVariable("debit") double debit) {

		Page<Supplier> supplierList = particularRepository.findSuppliersTotalDebitMin(debit,
				PageRequest.of(3, 15, Sort.by("totalDebit").descending()));
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
