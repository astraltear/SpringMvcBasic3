package com.astraltear.springmvcbasic3.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/propertyConfig")
@PropertySource("classpath:config.properties")
public class PropertyController {
	
	private static final Logger logger = LoggerFactory.getLogger(PropertyController.class);
	
	// 프로퍼티 파일 읽기
    @Value("${doc.path}")
    private String m_docPath ;
	
	@RequestMapping( method=RequestMethod.GET)
	@ResponseBody
	public String getProperty() {
		logger.info("m_docPath {}",m_docPath);
		return m_docPath;
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
