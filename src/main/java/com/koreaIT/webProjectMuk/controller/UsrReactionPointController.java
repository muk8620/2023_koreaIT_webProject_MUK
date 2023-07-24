package com.koreaIT.webProjectMuk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreaIT.webProjectMuk.service.ReactionPointService;
import com.koreaIT.webProjectMuk.util.Util;
import com.koreaIT.webProjectMuk.vo.ReactionPoint;
import com.koreaIT.webProjectMuk.vo.ResultData;
import com.koreaIT.webProjectMuk.vo.Rq;

@Controller
public class UsrReactionPointController {
	private ReactionPointService reactionPointService;
	private Rq rq;
	
	@Autowired
	public UsrReactionPointController(ReactionPointService reactionPointService, Rq rq) {
		this.reactionPointService = reactionPointService;
		this.rq = rq;
	}
	
	@RequestMapping("/usr/reactionPoint/getReactionPoint")
	@ResponseBody
	public ResultData<ReactionPoint> getReactionPoint(String relTypeCode, int relId) {
		
		ReactionPoint reactionPoint = reactionPointService.getReactionPoint(relTypeCode, relId, rq.getLoginedMemberId());
		
		return ResultData.from("S-1", "리액션 정보 조회 성공", "reactionPoint", reactionPoint);
	}
	
	@RequestMapping("/usr/reactionPoint/doInsertReactionPoint")
	@ResponseBody
	public String doInsertReactionPoint(String relTypeCode, int relId, int point) {
		
		reactionPointService.doDeleteReactionPoint(relTypeCode, relId, rq.getLoginedMemberId(), point);
		
		reactionPointService.doInsertReactionPoint(relTypeCode, relId, rq.getLoginedMemberId(), point);
		
		if (point == 1) {
			return Util.jsReplace(Util.f("%d번 글에 좋아요", relId), Util.f("../article/detail?id=%d", relId));
		} else {
			return Util.jsReplace(Util.f("%d번 글에 싫어요", relId), Util.f("../article/detail?id=%d", relId));
		}
		
	}
	
	@RequestMapping("/usr/reactionPoint/doDeleteReactionPoint")
	@ResponseBody
	public String doDeleteReactionPoint(String relTypeCode, int relId, int point) {
		
		reactionPointService.doDeleteReactionPoint(relTypeCode, relId, rq.getLoginedMemberId(), point);
		
		if (point == 1) {
			return Util.jsReplace(Util.f("%d번 글에 좋아요 취소", relId), Util.f("../article/detail?id=%d", relId));
		} else {
			return Util.jsReplace(Util.f("%d번 글에 싫어요 취소", relId), Util.f("../article/detail?id=%d", relId));
		}
	}
}
