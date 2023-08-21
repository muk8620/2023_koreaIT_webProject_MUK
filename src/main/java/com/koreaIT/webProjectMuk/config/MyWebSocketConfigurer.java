package com.koreaIT.webProjectMuk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.koreaIT.webProjectMuk.handler.ChatHandler;

@Configuration
@EnableWebSocket
public class MyWebSocketConfigurer implements WebSocketConfigurer{

	private ChatHandler chatHandler;
	
	@Autowired
	public MyWebSocketConfigurer(ChatHandler chatHandler){
		this.chatHandler = chatHandler;
	}
	
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(chatHandler, "/chatting")
				.setAllowedOriginPatterns("http://localhost:8081")
		        .withSockJS()
				.setClientLibraryUrl("https://cdn.jsdelivr.net/npm/sockjs-client@1.6.1/dist/sockjs.min.js");
	}
}