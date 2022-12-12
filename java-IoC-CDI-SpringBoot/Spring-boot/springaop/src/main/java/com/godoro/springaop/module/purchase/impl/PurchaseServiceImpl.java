package com.godoro.springaop.module.purchase.impl;

import org.springframework.stereotype.Service;

import com.godoro.springaop.module.purchase.PurchaseService;
@Service
public class PurchaseServiceImpl implements PurchaseService{

	@Override
	public String anything(String input) {
		return "Alış süreçle bir şey " + input;
	}

}
