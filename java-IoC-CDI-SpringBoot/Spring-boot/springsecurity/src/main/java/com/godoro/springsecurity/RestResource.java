package com.godoro.springsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestResource {
	
	 @GetMapping("/api/secure")
	 @ResponseBody
	public String getApiData() {
		
		return "{\"company\" : \"godoro\"}";
	}
}
