package com.koreaIT.webProjectMuk.controller;

import java.time.LocalTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreaIT.webProjectMuk.service.CalendarService;
import com.koreaIT.webProjectMuk.util.Util;
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
	
	@RequestMapping("/usr/calendar/write")
	public String write(Model model, String date) {
		
		model.addAttribute("date", date);
		model.addAttribute("time", LocalTime.now().getHour());
		return "usr/calendar/write";
	}
	
	@RequestMapping("/usr/calendar/doWrite")
	@ResponseBody
	public String doWrite(String title, String start, String startTime, String end, String endTime, boolean allDay) {
		
		if (title == null) {
			return Util.jsHistoryBack("제목을 입력해주세요.");
		}
		
		if (start == null || end == null) {
			return Util.jsHistoryBack("날짜를 입력해주세요.");
		}
		
		calendarService.insertCalender(rq.getLoginedMemberId(), title, start, startTime, end, endTime, allDay);
		
		return Util.jsReplace("일정이 추가되었습니다.", "list");
	}
	
}