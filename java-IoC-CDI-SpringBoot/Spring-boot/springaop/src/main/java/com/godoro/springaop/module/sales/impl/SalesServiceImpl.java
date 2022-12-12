package com.godoro.springaop.module.sales.impl;

import org.springframework.stereotype.Service;

import com.godoro.springaop.module.sales.SalesService;

@Service
public class SalesServiceImpl implements SalesService{

	@Override
	public String performSomething(String input) {
		if (input.equals("Yanlış")) {
			throw new IllegalArgumentException("Girdi yanlış");
		}
		return "Satış yap " + input;
	}

	@Override
	public String performAnother(String input) {
		return "Satış yap başka" + input;
	}

	@Override
	public String handleSomething(String input) {
		return "Satış kotar " + input;
	}

}
