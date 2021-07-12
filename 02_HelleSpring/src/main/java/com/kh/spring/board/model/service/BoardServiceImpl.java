package com.kh.spring.board.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.spring.board.model.dao.BoardDao;
import com.kh.spring.board.model.vo.Attachment;
import com.kh.spring.board.model.vo.Board;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BoardServiceImpl implements BoardService {
	@Autowired
	private SqlSessionTemplate session;
	@Autowired
	private BoardDao dao;
	
	@Override
	public List<Board> selectBoardList(int cPage, int numPerpage) {
		return dao.selectBoardList(session, cPage, numPerpage);
	}

	@Override
	public int selectBoardCount() {
		// TODO Auto-generated method stub
		return dao.selectBoardCount(session);
	}

	@Override
	/* @Transactional */
	public int insertBoard(Board b) throws RuntimeException{
		int result=dao.insertBoard(session, b);
		log.info("{}",b.getBoardNo());
		if(result>0) {
			if(b.getAttachments().size()>0) {
				for(Attachment a : b.getAttachments()) {
					try {
						a.setBoardNo(b.getBoardNo());
						result=dao.insertAttachment(session,a);
					}catch(RuntimeException e){
						throw new RuntimeException("작성실패");
					}
				}
			}
		}
		return result;
	}

	@Override
	public Board selectBoardView(int no) {
		return dao.selectBoardView(session,no);
	}

	
	
	
}
