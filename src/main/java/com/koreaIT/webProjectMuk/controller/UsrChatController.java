package com.koreaIT.webProjectMuk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsrChatController {
	
	@RequestMapping("/usr/chat/chatting")
	public String chat() {
		return "usr/chat/chatting";
	}
}