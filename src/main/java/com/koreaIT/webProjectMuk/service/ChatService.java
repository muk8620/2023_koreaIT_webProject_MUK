package com.koreaIT.webProjectMuk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreaIT.webProjectMuk.dao.ChatDao;
import com.koreaIT.webProjectMuk.dto.ChatRoomDTO;

@Service
public class ChatService {
	private ChatDao chatDao;
	
	@Autowired
	public ChatService(ChatDao chatDao) {
		this.chatDao = chatDao;
	}

	public List<ChatRoomDTO> getRooms() {
		return chatDao.getRooms();
	}
	
	public ChatRoomDTO getRoomById(String name) {
		return chatDao.getRoomById(name);
	}

	public void createChatRoom(String name) {
		chatDao.createChatRoom(name);
	}

}
