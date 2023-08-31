package com.koreaIT.webProjectMuk.controller;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreaIT.webProjectMuk.dto.ChatMessageDTO;
import com.koreaIT.webProjectMuk.dto.ChatRoomDTO;
import com.koreaIT.webProjectMuk.service.ChatService;
import com.koreaIT.webProjectMuk.util.Util;
import com.koreaIT.webProjectMuk.vo.Rq;

@Controller
public class UsrChatRoomController {
	
	private ChatService chatService;
	private Rq rq;
	
	@Autowired
	public UsrChatRoomController(ChatService chatService, Rq rq){
		this.chatService = chatService;
		this.rq = rq;
	}
	
	//채팅방 개설
	@ResponseBody
	@GetMapping("/usr/chat/doCreate")	
	public String doCreate(@RequestParam(defaultValue = "채팅") String name){
		
		chatService.createChatRoom(name, rq.getLoginedMemberId());
		
		return Util.jsReplace(Util.f("%s방이 생성되었습니다.", name), "rooms");
	}

    //채팅방 목록 조회
    @GetMapping("/usr/chat/rooms")
    public String showRooms(Model model){
    	
    	List<ChatRoomDTO> rooms = chatService.getRooms();
        model.addAttribute("rooms", rooms);

        return "usr/chat/rooms";
    }

    //채팅방 조회
    @GetMapping("/usr/chat/room/{id}")
    public String showRoom(@PathVariable("id") int id, Model model){
    	
    	ChatRoomDTO room = chatService.getRoomByRoomId(id);
    	int userCheck = chatService.getRoomByRoomIdAndMemberId(id, rq.getLoginedMemberId());
    	
    	List<ChatMessageDTO> messages = chatService.getMessages(room.getId());
    	
    	JSONArray jsonArrayMessage = new JSONArray();
    	
    	try {
			for (ChatMessageDTO message : messages) {
	            JSONObject messageJson = new JSONObject();
	            messageJson.put("message", message.getForPrintMessage());
	            messageJson.put("regDate", message.getRegDate());
	            messageJson.put("writer", message.getWriter());
	            
	            jsonArrayMessage.add(messageJson);
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
        model.addAttribute("room", room);
        model.addAttribute("messages", jsonArrayMessage);
        model.addAttribute("loginedMember", rq.getLoginedMember());
        
        return "usr/chat/room";
    }
}
