package com.koreaIT.webProjectMuk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.koreaIT.webProjectMuk.dto.ChatMessageDTO;
import com.koreaIT.webProjectMuk.service.ChatService;
import com.koreaIT.webProjectMuk.util.Util;

@Controller
public class UsrChatStompController {
	
	private SimpMessagingTemplate template; //특정 Broker로 메세지를 전달
	private ChatService chatService;
	
	@Autowired
	public UsrChatStompController(SimpMessagingTemplate template, ChatService chatService){
		this.template = template;
		this.chatService = chatService;
	}
	
    //Client가 SEND할 수 있는 경로
    //stompConfig에서 설정한 applicationDestinationPrefixes와 @MessageMapping 경로가 병합됨
    //"/pub/chat/enter"
    @MessageMapping("/chat/enter")
    public void enter(ChatMessageDTO message){
    	int roomId = message.getRoomId();
    	int memberId = message.getMemberId();
    	
    	int room = chatService.getRoomByRoomIdAndMemberId(roomId, memberId);
    	
    	if (room == 0) {
    		String body = message.getWriter() + "님이 채팅방에 참여하였습니다.\n";
    		String regDate = Util.now();
    		
    		int insertCheck = chatService.doInsertMessage(regDate, 1, roomId, body);
    		
    		if (insertCheck == 0) {
        		message.setMessage("방 입장에 실패했습니다.");
        		template.convertAndSend("/sub/usr/chat/room?id=" + message.getRoomId(), message);
        		return;
        	}
    		
    		chatService.doIncreaseParticipant(roomId, memberId);
    		
    		message.setMessage(body);
    		message.setRegDate(regDate);
    		message.setWriter("admin");
    		
    		template.convertAndSend("/sub/usr/chat/room?id=" + roomId, message);
    		
    	}
    }
    
    @MessageMapping("/chat/exit")
    public void exit(ChatMessageDTO message){
    	int roomId = message.getRoomId();
    	int memberId = message.getMemberId();
    	
    	int room = chatService.getRoomByRoomIdAndMemberId(roomId, memberId);
    	
    	if (room != 0) {
    		String body = message.getWriter() + "님이 채팅방에서 나갔습니다.\n";
    		
    		chatService.doDeleteParticipant(roomId, memberId);
    		chatService.doInsertMessage(Util.now(), 1, roomId, body);
    		
    		message.setMessage(body);
    		message.setWriter("admin");
    		
    		template.convertAndSend("/sub/usr/chat/room?id=" + roomId, message);
    		
    	}
    }
    
    @MessageMapping("/chat/message")
    public void message(ChatMessageDTO message){
    	int memberId = message.getMemberId();
    	int roomId = message.getRoomId(); 
        String body = message.getMessage();
        String regDate = Util.now();
        	
    	int insertCheck = chatService.doInsertMessage(regDate, memberId, roomId, body);
    	
    	if (insertCheck == 0) {
    		message.setMessage("메시지 전송에 실패했습니다.");
    		template.convertAndSend("/sub/usr/chat/room?id=" + message.getRoomId(), message);
    		return;
    	}
    	
    	message.setRegDate(regDate);
    	
        template.convertAndSend("/sub/usr/chat/room?id=" + message.getRoomId(), message);
    }
}