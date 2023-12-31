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

	public void doIncreaseParticipant(String regDate, int roomId, int memberId) {
		chatRoomDao.doIncreaseParticipant(regDate, roomId, memberId);
	}

	public String getRegDateByRoomIdAndMemberId(int roomId, int memberId) {
		return chatRoomDao.getRegDateByRoomIdAndMemberId(roomId, memberId);
	}

	public int doInsertMessage(String regDate, int memberId, int roomId, String body) {
		chatRoomDao.doInsertMessage(regDate, memberId, roomId, body);
		return 1;
	}
	
	public List<ChatMessageDTO> getMessagesByRegDate(int id, String userCheckRegDate) {
		return chatRoomDao.getMessagesByRegDate(id, userCheckRegDate);
	}

	public void doDeleteParticipant(int roomId, int memberId) {
		chatRoomDao.doDeleteParticipant(roomId, memberId);
	}

}
