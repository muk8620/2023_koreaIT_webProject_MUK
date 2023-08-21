package com.koreaIT.webProjectMuk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreaIT.webProjectMuk.dao.ChatDao;

@Service
public class ChatService {
	private ChatDao chatDao;
	
	@Autowired
	public ChatService(ChatDao chatDao) {
		this.chatDao = chatDao;
		
	}
	
	

}
