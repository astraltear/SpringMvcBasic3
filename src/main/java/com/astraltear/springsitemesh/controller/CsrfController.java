package com.astraltear.springsitemesh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/users")
public class CsrfController {

	@RequestMapping("/auth/first")
	public String csrf1() {
		return "/csrf/first";
	}

	@RequestMapping( value="/auth/second", method=RequestMethod.POST)
	public String csrf2() {
		return "/csrf/second";
	}

	@RequestMapping(value="/auth/third", method=RequestMethod.POST)
	public String csrf3() {
		return "/csrf/third";
	}

}
