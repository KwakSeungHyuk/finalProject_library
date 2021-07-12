package com.kh.spring.board.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.spring.board.model.vo.Attachment;
import com.kh.spring.board.model.vo.Board;

public interface BoardDao {
	List<Board> selectBoardList(SqlSessionTemplate session, int cPage, int numPerpage);
	int selectBoardCount(SqlSessionTemplate session);
	int insertBoard(SqlSessionTemplate session, Board b);
	int insertAttachment(SqlSessionTemplate session, Attachment a);
	Board selectBoardView(SqlSessionTemplate session,int no);
}







