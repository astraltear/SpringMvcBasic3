package com.astraltear.springmvcbasic3.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/interceptorLogin")
public class InterCeptorController {
	
	@RequestMapping(value="login")
	public String interLogin() {
		return "/interceptor/login";
	}
	
	@RequestMapping(value="/board_write ")
	public String board_write() {
		return "interceptor/board_write";
	}
	
	@RequestMapping(value="/setSession")
	public void loginCheck(HttpServletRequest request) {
		request.getSession().setAttribute("logininfo", true);
	}
	
}
