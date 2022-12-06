package com.godoro.springapp.presentation.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.godoro.springapp.bussiness.dto.ProductDto;
import com.godoro.springapp.bussiness.service.ProductService;



@RestController
public class ProductResource {
	@Autowired
	ProductService productService;
	
	@GetMapping(value="/rest/product/{id}")
	public ProductDto getProduct(@PathVariable("id") long productId) {
		ProductDto productDto = productService.find(productId);
		return productDto;
	}
	
	@GetMapping(value="/rest/product/list")
	public List<ProductDto> getProducts() {
		List<ProductDto> products = productService.list();
		return products;
	}
	
	@PostMapping(value="/rest/product")
	public ProductDto postProduct(@RequestBody ProductDto productDto) {
			productService.save(productDto);
		return productDto;
	}
	
	@PutMapping(value="/rest/product")
	public void putProduct(@RequestBody ProductDto productDto) {
			productService.save(productDto);
	}
	
	@DeleteMapping(value="/rest/product/{id}")
	public void deleteProduct(@PathVariable("id")	 long productId) {
			productService.delete(0);
	}
	
}
