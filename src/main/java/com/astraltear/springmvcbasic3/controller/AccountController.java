package com.astraltear.springmvcbasic3.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.astraltear.springmvcbasic3.domain.AccountForm;

@Controller
@RequestMapping("/account")
public class AccountController {
	private static final Logger log = LoggerFactory.getLogger(AccountController.class);
	
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String getRegForm(Model model) {
		
		AccountForm accountForm = new AccountForm();
		accountForm.setUsername("astraltear");
		accountForm.setPassword("1234");
		accountForm.setFirstName("KKK");
		
		model.addAttribute("account", accountForm);
		return "users/registrationForm";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(AccountForm form) {
		log.info("Created registration: {}", form);
		return "redirect:/account/registration_ok.html";
		
	}
}
