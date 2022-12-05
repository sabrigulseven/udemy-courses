package com.godoro.springrest.sports.service;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferResource {
	@GetMapping("/transfer/header")
	public ResponseEntity<?> getHeader(@RequestHeader(value = "input",defaultValue = "varsayılan") String input) {
		String output = "Giren: " + input;
		return ResponseEntity.ok(output);
				
	}
	
	@GetMapping("/transfer/cookie")
	public ResponseEntity<?> getCookie(@CookieValue(value = "input") String input) {
		String output = "Giren: " + input;
		return ResponseEntity.ok(output);
				
	}
}
