package com.godoro.springrest.sports.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class TransferController {
	@GetMapping("/client/header")
	@ResponseBody
	public String getHeader() {
		String url = "http://localhost:8080/transfer/header";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("input", "godoro");
		HttpEntity<String> entity = new HttpEntity<String>("Gövde", headers);
		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

		return "Başlık gönderildi: " + responseEntity.getBody();
	}

	@GetMapping("/client/cookie")
	@ResponseBody
	public String getCookie() {
		String url = "http://localhost:8080/transfer/cookie";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.COOKIE, "input=Godoro");
		HttpEntity<String> entity = new HttpEntity<String>("Gövde", headers);
		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

		return "Çerez gönderildi: " + responseEntity.getBody();
	}

	@GetMapping("/client/setheader")
	@ResponseBody
	public String setHeader() {
		String url = "http://localhost:8080/transfer/setheader";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY,
				String.class);
		String inputString = responseEntity.getHeaders().getFirst("input");
		return "Başlık gönderildi: " + responseEntity.getBody() + " başlık: " + inputString;
	}

	@GetMapping("/client/setcookie")
	@ResponseBody
	public String setCookie() {
		String url = "http://localhost:8080/transfer/setcookie";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY,
				String.class);
		String inputString = responseEntity.getHeaders().getFirst(HttpHeaders.SET_COOKIE);
		return "Çerez gönderildi: " + responseEntity.getBody() + " başlık: " + inputString;
	}
}
