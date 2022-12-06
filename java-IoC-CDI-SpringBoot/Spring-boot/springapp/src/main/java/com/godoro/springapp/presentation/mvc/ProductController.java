package com.godoro.springapp.presentation.mvc;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.godoro.springapp.data.entity.Product;
import com.godoro.springapp.data.repository.ProductRepository;

@Controller
public class ProductController {
	@Autowired
	private ProductRepository productRepository;

	@GetMapping(path = { "/product/edit" })
	public String editProduct(Model model) {
		Product product;
		product = new Product(0, "", 0.0);

		model.addAttribute("product", product);
		return "/inventory/ProductEdit";
	}
	
	@GetMapping(path = { "/product/edit/{id}" })
	public String editProduct(Model model, @PathVariable("id") long productId) {
		Product product;
		if (productId == 0) {
			product = new Product(0, "", 0.0);
		} else {
			Optional<Product> optional = productRepository.findById(productId);
			if (optional.isPresent()) {
				product = optional.get();
			} else {
				product = new Product(0, "", 0.0);
			}
		}
		model.addAttribute("product", product);
		return "/inventory/ProductEdit";
	}

	

	@PostMapping(path = { "/product/edit", "/product/edit/{id}" })
	public String editProduct(Model model, Product product, BindingResult result) {
		productRepository.save(product);
		if (result.hasErrors()) {
			result.addError(new ObjectError("product", "Biçim yanlış"));
			return "/inventory/ProductEdit";
		}
		model.addAttribute("message", "Başarıyla Eklendi");
		return "/inventory/ProductSuccess";

	}

	@GetMapping("/product/list")
	public String listProduct(Model model) {
		Iterable<Product> productList = productRepository.findAll();
		model.addAttribute("products", productList);
		// model.addAttribute("products", productRepository.findAll());
		model.addAttribute("message", "Ürünler");
		return "/inventory/ProductList";
	}

	@GetMapping("/product/delete/{id}")
	public String deleteProduct(Model model, @PathVariable("id") long productId) {
		productRepository.deleteById(productId);
		model.addAttribute("message", "Ürün Silindi: " + productId);
		model.addAttribute("products", productRepository.findAll());
		return "/inventory/ProductList";
	}
}
