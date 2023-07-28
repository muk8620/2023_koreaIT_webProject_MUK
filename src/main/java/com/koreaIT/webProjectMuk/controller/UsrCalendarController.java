package com.koreaIT.webProjectMuk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsrCalendarController {
	
	@RequestMapping("/usr/calendar/list")
	public String showMain() {
		return "usr/calendar/list";
	}
	
}