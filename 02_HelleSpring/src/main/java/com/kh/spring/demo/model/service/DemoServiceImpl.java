package com.kh.spring.demo.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.demo.model.dao.DemoDao;
import com.kh.spring.demo.model.vo.Dev;

@Service
public class DemoServiceImpl implements DemoService {

	@Autowired
	private SqlSessionTemplate sqlsession;
	
	@Autowired
	private DemoDao dao;
	
	@Override
	public int insertDemo(Dev d) {
		return dao.insertDemo(sqlsession, d);
	}

	@Override
	public List<Dev> selectDemoList() {
		return dao.selectDemoList(sqlsession);
	}

	
	
	
}
