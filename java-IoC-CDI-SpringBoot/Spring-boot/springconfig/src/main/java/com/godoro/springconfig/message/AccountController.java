package com.godoro.springconfig.message;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller	
public class AccountController {
	@Autowired
	private MessageSource messageSource;

	@GetMapping(path = { "/account/edit" })
	public String editaccount(Model model) {
		model.addAttribute("message", messageSource.getMessage("account.form.fill",null,null));
		Account account = new Account(0, "", 0.0);
		model.addAttribute("account", account);
		return "/ledger/AccountEdit";
	}

	@GetMapping(path = { "/account/edit/{id}" })
	public String editaccount(Model model, @PathVariable("id") long accountId) {
		Account account = new Account(accountId,"",0.0);
		model.addAttribute("account", account);
		return "/ledger/AccountEdit";
	}

	@PostMapping(path = { "/account/edit", "/account/edit/{id}" })
	public String editaccount(Model model,@Valid Account account, BindingResult result) {
		
		if (result.hasErrors()) {
			result.addError(new ObjectError("account", "Biçim yanlış"));
			return "/ledger/AccountEdit";
		}
		model.addAttribute("message", messageSource.getMessage("account.form.saved",null,null));
		model.addAttribute("account", account);
		return "/ledger/AccountEdit";

	}

}
