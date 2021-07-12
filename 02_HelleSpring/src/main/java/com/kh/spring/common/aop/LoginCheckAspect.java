package com.kh.spring.common.aop;

import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.kh.spring.member.model.vo.Member;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class LoginCheckAspect {
	//memo패키지 매소드 전부
	
	@Before("execution(* com.kh.spring.memo..*(..))")
	public void checkLogin(JoinPoint jp) {
		log.debug("===== 로그인체그하기 =====");
		HttpSession session=(HttpSession)RequestContextHolder.currentRequestAttributes()
		.resolveReference(RequestAttributes.REFERENCE_SESSION);
		
		Member loginMember=(Member)session.getAttribute("loginMember");
		
		if(loginMember == null) {
			//aop에서 진행되는 로직을 중단!
			//Exception으로 예외발생!
			try {
				throw new Exception("접속권한이 없습니다! 로그인 후 이용하세요");
			}catch(Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}
}







