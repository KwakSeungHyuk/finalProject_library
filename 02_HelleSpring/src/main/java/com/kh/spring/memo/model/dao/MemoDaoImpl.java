package com.kh.spring.memo.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemoDaoImpl implements MemoDao{

	@Override
	public int memoInsert(SqlSessionTemplate session, Map param) {
		// TODO Auto-generated method stub
		return session.insert("memo.memoInsert",param);
	}

	@Override
	public List<Map> selectMemoList(SqlSessionTemplate session) {
		// TODO Auto-generated method stub
		return session.selectList("memo.selectMemoList");
	}

	
}
