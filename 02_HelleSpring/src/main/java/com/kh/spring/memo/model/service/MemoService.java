package com.kh.spring.memo.model.service;

import java.util.List;
import java.util.Map;

public interface MemoService {
	int memeInsert(Map param);
	List<Map> selectMemoList();
}
