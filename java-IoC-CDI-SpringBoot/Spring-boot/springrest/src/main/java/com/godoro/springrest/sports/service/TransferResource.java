package com.godoro.springrest.sports.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferResource {
	@GetMapping("/transfer/header")
	public ResponseEntity<?> getHeader(@RequestHeader(value = "input", defaultValue = "varsayılan") String input) {
		String output = "Giren: " + input;
		return ResponseEntity.ok(output);

	}

	@GetMapping("/transfer/cookie")
	public ResponseEntity<?> getCookie(@CookieValue(value = "input") String input) {
		String output = "Giren: " + input;
		return ResponseEntity.ok(output);

	}

	@GetMapping("/transfer/setheader")
	public ResponseEntity<?> setHeader() {
		//HttpHeaders headers = new HttpHeaders();
		//headers.add("input", "Godoro");
		return ResponseEntity.ok()
				//.headers(headers)
				.header("input", "Godoro")
				.body("Başlık Gönderildi");

	}
	
	@GetMapping("/transfer/setcookie")
	public ResponseEntity<?> setCookie() {
		return ResponseEntity.ok()
				.header(HttpHeaders.SET_COOKIE, "Godoro")
				.body("Cookie Gönderildi");

	}
}
