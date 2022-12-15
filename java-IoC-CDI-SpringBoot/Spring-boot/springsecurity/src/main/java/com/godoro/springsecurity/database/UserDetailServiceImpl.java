package com.godoro.springsecurity.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserDetailServiceImpl implements UserDetailsService{
	/*
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findByUsername();
		String password=userEntity.getPassword();
		String role =userEntity.getRoles();
		return User.withUsername(username)
					.password(password)
					.roles(role)
					.build();
	}
	*/
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		String password="java";
		String role ="USER";
		return User.withUsername(username)
					.password(passwordEncoder.encode(password))
					.roles(role)
					.build();
	}
	
}
