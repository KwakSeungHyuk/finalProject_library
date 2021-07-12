package com.kh.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerTest {
	
	//로그를 출력해줄 객체를 선언하기
	private Logger logger=LoggerFactory.getLogger(LoggerTest.class);
	//private Logger logger2=
	public static void main(String[] args) {
		new LoggerTest().loggerTest();
	}
	public void loggerTest() {
		//Logger에서 제공하는 각 메소드를 이용해서 로그를 출력함
		//메소드의 매개변수는 String값으로 선언이 되어있음.
		logger.debug("debug 로그");
		logger.info("info 로그");
		logger.warn("warn 로그");
		logger.error("error 로그");
		
	}
	
}
