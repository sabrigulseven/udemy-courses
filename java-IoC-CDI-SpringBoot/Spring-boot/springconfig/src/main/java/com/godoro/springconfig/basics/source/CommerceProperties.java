package com.godoro.springconfig.basics.source;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
@Component
@ConfigurationProperties(prefix = "commerce")
@Validated
public class CommerceProperties {
	
	private String site;
	
	@Email
	private String emailAdress;
	
	@Min(1)
	@Max(7)
	private int returnDays;
	
	private Bank bank;
	
	public String getEmailAdress() {
		return emailAdress;
	}
	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public int getReturnDays() {
		return returnDays;
	}
	public void setReturnDays(int returnDays) {
		this.returnDays = returnDays;
	}
	
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
	public Bank getBank() {
		return bank;
	}
}
