package com.kh.spring.demo.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.spring.demo.model.vo.Dev;

public interface DemoDao {
	
	int insertDemo(SqlSessionTemplate sqlSession, Dev dev);
	List<Dev> selectDemoList(SqlSessionTemplate sqlsession);
}
