package com.godoro.springsecurity.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityTurnOnForm {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http
			.authorizeRequests()
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
		auth
			.inMemoryAuthentication()
			.withUser("godoro")
			.password("{noop}java")
			.roles("USER");
	}
	
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "/webjars/**");
	}

}
