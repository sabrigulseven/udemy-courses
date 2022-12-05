package com.godoro.springrest.sports.service;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnvironmentResource {
	
	@Autowired
	private ServletContext servletContext;
	
	@GetMapping("/environment/info")
	public ResponseEntity<?> getInfo(HttpServletRequest request) {
		String myoutput ="Bağlam: "+ request.getContextPath() + " Gösterici: " + request.getRequestURI();
		return ResponseEntity.ok(myoutput);
	}
	
	@GetMapping("/environment/config")
	public ResponseEntity<?> getConfig(HttpServletRequest request) {
		String myoutput = servletContext.getInitParameter("myinput");
		return ResponseEntity.ok(myoutput);
	}
}
