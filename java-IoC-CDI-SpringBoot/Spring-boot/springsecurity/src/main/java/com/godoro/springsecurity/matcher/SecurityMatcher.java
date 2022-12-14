package com.godoro.springsecurity.matcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityMatcher{

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http
			.authorizeRequests()
			.antMatchers("/","/home")
			.permitAll()
			.anyRequest()
			.authenticated()
			.and()
		.formLogin()
			.and()
		.httpBasic();

		return http.build();
	}
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth
			.inMemoryAuthentication()
			.withUser("godoro")
			.password(encoder.encode("java"))
			.roles("USER");
	}	

}
