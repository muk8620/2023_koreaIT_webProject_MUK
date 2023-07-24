package com.koreaIT.webProjectMuk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreaIT.webProjectMuk.dao.BoardDao;
import com.koreaIT.webProjectMuk.vo.Board;

@Service
public class BoardService {

	private BoardDao boardDao;

	@Autowired
	BoardService(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	public Board getBoardById(int id) {
		return boardDao.getBoardById(id);
	}

}
