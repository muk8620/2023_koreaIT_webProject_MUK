package com.koreaIT.webProjectMuk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.koreaIT.webProjectMuk.service.ChatService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UsrChatController {
	
	private ChatService chatService;
	
	@Autowired
	public UsrChatController(ChatService chatService){
		this.chatService = chatService;
	}
	
	@GetMapping("/usr/chat/chatting")
	public String chat(Model model) {
		
		model.addAttribute("username", Math.random());
		
		log.info("@ChatController, chat GET()");
		
		return "usr/chat/chatting";
	}
}