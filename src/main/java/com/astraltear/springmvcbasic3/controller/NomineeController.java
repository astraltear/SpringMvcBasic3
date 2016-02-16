package com.astraltear.springmvcbasic3.controller;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.astraltear.springmvcbasic3.domain.NomineeMember;

@Controller
public class NomineeController {
	
	
	private static final Logger log = Logger.getLogger(NomineeController.class);
	
	private String thanksViewName;

	public void setThanksViewName(String thanksViewName) {
		this.thanksViewName = thanksViewName;
	}

/*	@RequestMapping(method = RequestMethod.GET)
	public NomineeMember form() {
		log.info("form!! form!!form!!form!!form!!form!!form!!form!!form!!");
		return new NomineeMember();
	}*/
	
	@RequestMapping(method = RequestMethod.GET)
	public String getMethod() {
		log.info("getMethod!! getMethod!! getMethod!! getMethod!! getMethod!! getMethod!! ");
		return thanksViewName;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processFormData(NomineeMember member) {
		log.info("Processing nominee: " + member);
		return thanksViewName;
	}
}
