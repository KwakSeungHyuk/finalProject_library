package com.kh.spring.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggerInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		log.debug("===== start ======");
		log.debug(request.getRequestURI());
		log.debug("-------------------------");	
		/*
		 * Map map=request.getParameterMap();
		 * request.getSession().getAttribute("loginMember");
		 */
		return super.preHandle(request, response, handler);//무조건 true
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		log.debug("==========  view ===========");
		log.debug("view로 응답하기 전");
		//log.debug("응답 페이지 : {}",modelAndView.getViewName());
		//modelAndView.getModel().get("");
		log.debug("---------------------------------------------");
		super.postHandle(request, response, handler, modelAndView);
	}
	
	
	
	
}
