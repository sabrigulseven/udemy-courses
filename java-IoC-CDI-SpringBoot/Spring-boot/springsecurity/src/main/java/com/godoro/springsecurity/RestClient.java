package com.godoro.springsecurity;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class RestClient {
	@GetMapping("client/secure")
	@ResponseBody
	public String getSecureData() {
		String username="godoro";
		String password ="java";
		String url="http://localhost:8080/api/secure";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setBasicAuth(username, password);
		HttpEntity<String> entity = new HttpEntity<String>("Gövde",headers);
		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET,entity,String.class);
		return "Güvenli Gönderildi "+responseEntity.getBody();
	}
}
