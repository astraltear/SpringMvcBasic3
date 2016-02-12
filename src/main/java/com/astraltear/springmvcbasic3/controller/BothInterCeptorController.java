package com.astraltear.springmvcbasic3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.astraltear.springmvcbasic3.annotation.LoggingCheck;

@Controller
@RequestMapping("/bothInterceptor")
public class BothInterCeptorController {
	
	@RequestMapping("/noLogging")
	@ResponseBody
	public String noLogging() {
		return "noLogging";
	}
	
	@RequestMapping("/logging")
	@ResponseBody
	@LoggingCheck
	public String logging() {
		return "logging";
	}
}
