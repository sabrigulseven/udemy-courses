package com.godoro.springaop.module.sales.impl;

import org.springframework.stereotype.Service;

import com.godoro.springaop.module.sales.SalesService;

@Service
public class SalesServiceImpl implements SalesService{

	@Override
	public String performSamething(String input) {
		
		return "Satış yap " + input;
	}

}
