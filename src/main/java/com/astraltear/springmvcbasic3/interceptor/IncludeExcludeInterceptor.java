package com.astraltear.springmvcbasic3.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.astraltear.springmvcbasic3.annotation.LoggingCheck;

public class IncludeExcludeInterceptor extends HandlerInterceptorAdapter {
	protected Log log = LogFactory.getLog(IncludeExcludeInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		if (checkLogging(handler)) {
			log.info("======================================          START         ======================================");
			log.info(" Request URI \t:  " + request.getRequestURI());
		}
		
		return super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		if (checkLogging(handler)) {
			log.info("======================================           END          ======================================\n");
		}
		super.postHandle(request, response, handler, modelAndView);
	}
	
	
	private boolean checkLogging(Object handler) {
		//컨트롤러에  NoLoggingCheck 어노테이션이 사용되었는지 체크한다. 
		LoggingCheck check = ((HandlerMethod)handler).getMethodAnnotation(LoggingCheck.class);
		
		if (check == null) {
			return false;
		} else {
			return true;
		}
	}

}
