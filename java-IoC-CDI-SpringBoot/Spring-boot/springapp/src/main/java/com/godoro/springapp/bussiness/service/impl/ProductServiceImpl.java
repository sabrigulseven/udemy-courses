package com.godoro.springapp.bussiness.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.godoro.springapp.bussiness.dto.ProductDto;
import com.godoro.springapp.bussiness.service.ProductService;
import com.godoro.springapp.data.entity.Product;
import com.godoro.springapp.data.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void save(ProductDto productDto) {
		Product product =convertToEntity(productDto);
		productRepository.save(product);
	}

	@Override
	public ProductDto find(long productId) {
		ProductDto productDto = new ProductDto();
		Optional<Product> optional = productRepository.findById(productId);

		if (optional.isPresent()) {
			Product product = optional.get();
			productDto = convertToDto(product);

		} else {
			productDto = new ProductDto(0, "", 0.0);
		}
		return productDto;
	}

	@Override
	public List<ProductDto> list() {
		List<ProductDto> productDtoList = new ArrayList<>();
		Iterable<Product> productList = productRepository.findAll();
		for (Product product : productList) {
			ProductDto productDto = convertToDto(product);
			productDtoList.add(productDto);
		}
		return productDtoList;
	}
	@Override
	public void delete(long productId) {
		productRepository.deleteById(productId);
	}
	private ProductDto convertToDto(Product product) {
		ProductDto productDto = new ProductDto();
		productDto.setProductId(product.getProductId());
		productDto.setProductName(product.getProductName());
		productDto.setSalesPrice(product.getSalesPrice());
		return productDto;
	}

	private Product convertToEntity(ProductDto productDto) {
		Product product = new Product();
		product.setProductId(productDto.getProductId());
		product.setProductName(productDto.getProductName());
		product.setSalesPrice(productDto.getSalesPrice());
		return product;
	}
}
