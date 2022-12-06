package com.godoro.springclient.bussiness.service;

import java.util.List;

import com.godoro.springclient.bussiness.dto.ProductDto;


public interface ProductService {
	public void save(ProductDto dto);
	public ProductDto find(long productId);
	public List<ProductDto> list();
	public void delete(long productId);

	
}
