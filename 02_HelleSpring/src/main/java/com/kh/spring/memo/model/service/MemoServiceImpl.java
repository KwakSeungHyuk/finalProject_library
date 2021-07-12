package com.kh.spring.memo.model.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.memo.model.dao.MemoDao;
@Service
public class MemoServiceImpl implements MemoService{
	
	@Autowired
	private SqlSessionTemplate session;
	
	@Autowired
	private MemoDao dao;
	
	@Override
	public int memeInsert(Map param) {
		// TODO Auto-generated method stub
		return dao.memoInsert(session,param);
	}

	@Override
	public List<Map> selectMemoList() {
		// TODO Auto-generated method stub
		return dao.selectMemoList(session);
	}
	
	
	
}
