package com.godoro.springtemplates.crud;


import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class MessagesConfiguration {
	private Locale LOCALE_UZ= new Locale("uz","UZ");
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver sessionLocaleResolver= new SessionLocaleResolver();
		sessionLocaleResolver.setDefaultLocale(LOCALE_UZ);
		return sessionLocaleResolver;
	}
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultLocale(LOCALE_UZ);
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

}