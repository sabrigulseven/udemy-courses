package com.godoro.springclient.data.client.impl;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.godoro.springclient.bussiness.dto.ProductDto;
import com.godoro.springclient.data.client.ProductClient;

@Component
public class ProductClientImpl implements ProductClient {
	private final static String URL_BASE = "http://localhost:8080/rest/product";
	private RestTemplate restTemplate = new RestTemplate();

	public ProductDto getProduct(long productId) {
		String url = URL_BASE + "/" + productId;
		ProductDto productDto = restTemplate.getForObject(url, ProductDto.class);
		return productDto;
	}

	public List<ProductDto> getProducts() {
		String url = URL_BASE + "/list";
		ResponseEntity<List<ProductDto>> response = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY,
				new ParameterizedTypeReference<List<ProductDto>>() {
				});
		List<ProductDto> productDtoList = response.getBody();
		return productDtoList;
	}

	public ProductDto postProduct(ProductDto productDto) {
		ProductDto result = restTemplate.postForObject(URL_BASE, productDto, ProductDto.class);
		return result;
	}

	public void putProduct(ProductDto productDto) {
		restTemplate.exchange(URL_BASE, HttpMethod.PUT, new HttpEntity<ProductDto>(productDto), Void.class);
	}

	public void deleteProduct(long productId) {
		String url = URL_BASE + "/" + productId;
		restTemplate.exchange(url, HttpMethod.DELETE, HttpEntity.EMPTY, Void.class);

	}
}
