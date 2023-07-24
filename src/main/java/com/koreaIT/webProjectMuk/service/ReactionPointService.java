package com.koreaIT.webProjectMuk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreaIT.webProjectMuk.dao.ReactionPointDao;
import com.koreaIT.webProjectMuk.vo.ReactionPoint;
import com.koreaIT.webProjectMuk.vo.ResultData;

@Service
public class ReactionPointService {
	private ReactionPointDao reactionPointDao;
	
	@Autowired
	public ReactionPointService(ReactionPointDao reactionPointDao) {
		this.reactionPointDao = reactionPointDao;
	}
	
	public ReactionPoint getReactionPoint(String relTypeCode, int relId, int memberId) {
		
		ReactionPoint reactionpoint = reactionPointDao.getReactionPoint(relTypeCode, relId, memberId);
		
		return reactionpoint;
	}

	public int doDeleteReactionPoint(String relTypeCode, int relId, int memberId, int point) {
		
		return reactionPointDao.doDeleteReactionPoint(relTypeCode, relId, memberId, point);
	}
	
	public void doInsertReactionPoint(String relTypeCode, int relId, int memberId, int point) {
		
		reactionPointDao.doInsertReactionPoint(relTypeCode, relId, memberId, point);
	}
	

}
