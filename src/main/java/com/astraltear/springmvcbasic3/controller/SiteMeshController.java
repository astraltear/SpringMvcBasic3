package com.astraltear.springmvcbasic3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sitemeshlayout")
public class SiteMeshController {

	@RequestMapping("/init")
	public String init() {
		return "home";
	}
	
	@RequestMapping("/test")
	@ResponseBody
	public String test() {
		return "test";
	}
}
