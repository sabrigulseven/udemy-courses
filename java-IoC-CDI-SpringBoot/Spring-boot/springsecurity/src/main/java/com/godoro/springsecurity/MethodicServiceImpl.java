package com.godoro.springsecurity;

import javax.annotation.security.RolesAllowed;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class MethodicServiceImpl implements MethodicService{
	
	//@Secured("ROLE_ADMIN")
	@RolesAllowed("ROLE_ADMIN")
	@Override
	public String getAdminValue() {
		return "Yönetici Değeri";
	}
	
	@Secured("ROLE_USER")
	@Override
	public String getUserValue() {
		return "Kullanıcı Değeri";
	}
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	@Override
	public String getAuthorizedValue() {
		return "getAuthorizedValue";
	}
}
