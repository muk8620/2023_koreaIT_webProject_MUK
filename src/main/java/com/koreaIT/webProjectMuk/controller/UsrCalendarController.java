package com.koreaIT.webProjectMuk.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreaIT.webProjectMuk.service.CalendarService;
import com.koreaIT.webProjectMuk.vo.Calendar;
import com.koreaIT.webProjectMuk.vo.Rq;

@Controller
public class UsrCalendarController {
		
	private CalendarService calendarService;
	private Rq rq;
	
	@Autowired
	public UsrCalendarController(CalendarService calendarService, Rq rq) {
		this.calendarService = calendarService;
		this.rq = rq;
	}
	
	@RequestMapping("/usr/calendar/list")
	public String showMain() {
		return "usr/calendar/list";
	}
	
	@RequestMapping("/usr/calendar/getCalendarList")
	@ResponseBody
	public ArrayList<Calendar> getCalendarList() {
		
		ArrayList<Calendar> calendarList = calendarService.getCalendarList(rq.getLoginedMemberId());
		return calendarList;
	}
	
}