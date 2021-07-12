package com.kh.spring.demo.model.service;

import java.util.List;

import com.kh.spring.demo.model.vo.Dev;

public interface DemoService {

	int insertDemo(Dev d);
	
	List<Dev> selectDemoList();
}
