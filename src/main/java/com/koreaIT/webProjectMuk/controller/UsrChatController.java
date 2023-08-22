package com.koreaIT.webProjectMuk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.koreaIT.webProjectMuk.dao.ChatDao;
import com.koreaIT.webProjectMuk.dto.ChatRoomDTO;
import com.koreaIT.webProjectMuk.service.ChatService;

@Controller
@RequestMapping(value = "/usr/chat")
public class UsrChatController {
	
	private ChatService chatService;
	
	@Autowired
	public UsrChatController(ChatService chatService){
		this.chatService = chatService;
	}
	
	@GetMapping("/chatting")
	public String chat(Model model) {
		
		model.addAttribute("username", Math.random());
		
		return "usr/chat/chatting";
	}

    //채팅방 목록 조회
    @GetMapping(value = "/rooms")
    public String showRooms(Model model){
    	
    	List<ChatRoomDTO> rooms = chatService.getRooms();
        model.addAttribute("rooms", rooms);

        return "usr/chat/rooms";
    }

    //채팅방 개설
    @GetMapping("/createRoom")	
    public String create(@RequestParam String name, RedirectAttributes rttr){
    	
    	chatService.createChatRoom(name);
    	ChatRoomDTO room = chatService.getRoomById(name);
    	
        rttr.addFlashAttribute("room", room);
        
        return "redirect:/usr/chat/rooms";
    }

    //채팅방 조회
    @GetMapping("/room")
    public String showRoom(String roomId, Model model){
    	
    	chatService.createChatRoom(roomId);
    	ChatRoomDTO room = chatService.getRoomById(roomId);

        model.addAttribute("room", room);
        
        return "usr/chat/room";
    }
}
