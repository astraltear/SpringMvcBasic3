package com.astraltear.springsitemesh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class CsrfController {

	@RequestMapping("/auth/first")
	public String csrf1() {
		return "/csrf/first";
	}

	@RequestMapping("/auth/second")
	public String csrf2() {
		return "/csrf/second";
	}

	@RequestMapping("/auth/third")
	public String csrf3() {
		return "/csrf/third";
	}

}
