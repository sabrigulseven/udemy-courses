package com.godoro.springclient.presentation.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.godoro.springclient.bussiness.dto.ProductDto;
import com.godoro.springclient.bussiness.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@GetMapping(path = { "/product/edit" })
	public String editProduct(Model model) {
		ProductDto productDto;
		productDto = new ProductDto(0, "", 0.0);
		model.addAttribute("product", productDto);
		return "/inventory/ProductEdit";
	}

	@GetMapping(path = { "/product/edit/{id}" })
	public String editProduct(Model model, @PathVariable("id") long productId) {
		ProductDto productDto = productService.find(productId);
		model.addAttribute("product", productDto);
		return "/inventory/ProductEdit";
	}

	@PostMapping(path = { "/product/edit", "/product/edit/{id}" })
	public String editProduct(Model model, ProductDto productDto, BindingResult result) {
		productService.save(productDto);
		if (result.hasErrors()) {
			result.addError(new ObjectError("product", "Biçim yanlış"));
			return "/inventory/ProductEdit";
		}
		model.addAttribute("message", "Başarıyla Eklendi");
		model.addAttribute("product", productDto);
		return "/inventory/ProductSuccess";

	}

	@GetMapping("/product/list")
	public String listProduct(Model model) {
		List<ProductDto> productDtoList = productService.list();
		model.addAttribute("products", productDtoList);
		// model.addAttribute("products", productRepository.findAll());
		model.addAttribute("message", "Ürünler");
		return "/inventory/ProductList";
	}

	@GetMapping("/product/delete/{id}")
	public String deleteProduct(Model model, @PathVariable("id") long productId) {
		productService.delete(productId);
		model.addAttribute("message", "Ürün Silindi: " + productId);
		List<ProductDto> productDtoList = productService.list();
		model.addAttribute("products", productDtoList);
		return "/inventory/ProductList";
	}
}
