package com.kh.spring.memo.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

public interface MemoDao {
	int memoInsert(SqlSessionTemplate session, Map param);
	List<Map> selectMemoList(SqlSessionTemplate session);
}
