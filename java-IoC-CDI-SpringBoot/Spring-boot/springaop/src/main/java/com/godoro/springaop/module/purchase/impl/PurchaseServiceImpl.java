package com.godoro.springaop.module.purchase.impl;

import org.springframework.stereotype.Service;

import com.godoro.springaop.module.purchase.PurchaseService;
import com.godoro.springaop.system.aspect.Logged;
@Service
public class PurchaseServiceImpl implements PurchaseService{

	@Override
	public String anything(String input) {
		return "Alış süreçle bir şey " + input;
	}
	@Logged
	@Override
	public String processDifferent(String input) {
		return "Alış farklı bir şey " + input;
	}

}
