package com.kh.spring.member.model.service;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.member.model.dao.MemberDao;
import com.kh.spring.member.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private SqlSessionTemplate session;
	@Autowired
	private MemberDao dao;
	
	@Override
	public int insertMember(Member m) {
		return dao.insertMember(session,m);
	}

	@Override
	public Member selectMember(Map param) {
		return dao.selectMember(session,param);
	}
	
}
