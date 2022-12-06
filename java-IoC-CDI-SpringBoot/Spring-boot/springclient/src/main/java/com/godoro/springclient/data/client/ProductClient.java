package com.godoro.springclient.data.client;

import java.util.List;

import com.godoro.springclient.bussiness.dto.ProductDto;

public interface ProductClient {

	public ProductDto getProduct(long productId);

	public List<ProductDto> getProducts();

	public ProductDto postProduct(ProductDto productDto);

	public void putProduct(ProductDto productDto);

	public void deleteProduct(long productId);
}
