package com.koreaIT.webProjectMuk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreaIT.webProjectMuk.dao.ChatDao;
import com.koreaIT.webProjectMuk.dto.ChatMessageDTO;
import com.koreaIT.webProjectMuk.dto.ChatRoomDTO;

@Service
public class ChatService {
	private ChatDao chatRoomDao;
	
	@Autowired
	public ChatService(ChatDao chatRoomDao) {
		this.chatRoomDao = chatRoomDao;
	}
	
	public void createChatRoom(String name, int creatorId) {
		chatRoomDao.createChatRoom(name, creatorId);
	}

	public List<ChatRoomDTO> getRooms() {
		return chatRoomDao.getRooms();
	}
	
	public ChatRoomDTO getRoomByRoomId(int id) {
		return chatRoomDao.getRoomByRoomId(id);
	}

	public void doIncreaseParticipant(int roomId, int memberId) {
		chatRoomDao.doIncreaseParticipant(roomId, memberId);
	}

	public int getRoomByRoomIdAndMemberId(int roomId, int memberId) {
		return chatRoomDao.getRoomByRoomIdAndMemberId(roomId, memberId);
	}

	public int doInsertMessage(int memberId, int relId, String body) {
		return chatRoomDao.doInsertMessage(memberId, relId, body);
	}

	public List<ChatMessageDTO> getMessages(int roomId) {
		return chatRoomDao.getMessages(roomId);
	}

	

}