package com.astraltear.springsitemesh.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HiddenHttpMethodTestController {
	
	private static final Logger logger = LoggerFactory.getLogger(HiddenHttpMethodTestController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		return "home";
	}
	
	@RequestMapping(value="/methodfilter/httpmethodTest", method=RequestMethod.POST)
	@ResponseBody
	public String postMethod() {
		return "call post method";
	}
	
	@RequestMapping(value="/methodfilter/httpmethodTest", method=RequestMethod.PUT)
	@ResponseBody
	public String putMehtod() {
		return "call put method";
	}
	
	@RequestMapping(value="/methodfilter/httpmethodTest", method=RequestMethod.DELETE)
	@ResponseBody
	public String deleteMehtod() {
		return "call delete method";
	}
	
	@RequestMapping(value="/NonMethodfilter/httpmethodTest", method=RequestMethod.POST)
	@ResponseBody
	public String NonpostMethod() {
		return "call Non post method";
	}
	
	@RequestMapping(value="/NonMethodfilter/httpmethodTest", method=RequestMethod.PUT)
	@ResponseBody
	public String NonputMehtod() {
		return "call Non put method";
	}
	
	@RequestMapping(value="/NonMethodfilter/httpmethodTest", method=RequestMethod.DELETE)
	@ResponseBody
	public String NondeleteMehtod() {
		return "call Non delete method";
	}	
}
