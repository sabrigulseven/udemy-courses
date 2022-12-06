package com.godoro.springclient.bussiness.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.godoro.springclient.bussiness.dto.ProductDto;
import com.godoro.springclient.bussiness.service.ProductService;
import com.godoro.springclient.data.client.ProductClient;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductClient productClient;

	@Override
	public void save(ProductDto productDto) {
		if (productDto.getProductId() == 0) {
			productClient.postProduct(productDto);
		} else {
			productClient.putProduct(productDto);
		}
	}

	@Override
	public ProductDto find(long productId) {
		return productClient.getProduct(productId);
	}

	@Override
	public List<ProductDto> list() {
		return productClient.getProducts();
	}

	@Override
	public void delete(long productId) {
		productClient.deleteProduct(productId);

	}

}