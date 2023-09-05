package com.koreaIT.webProjectMuk.controller;

import java.time.LocalTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public String showWrite(Model model, String date) {
		
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
	
	@RequestMapping("/usr/calendar/modify")
	public String showModify(Model model, int id) {
		
		Calendar calendar = calendarService.getCalendarByIdAndMemberId(id, rq.getLoginedMemberId());

		if (calendar == null) {
			return rq.jsReturnOnView("존재하지 않는 일정입니다.");
		}

		if (rq.getLoginedMemberId() != calendar.getMemberId()) {
			return rq.jsReturnOnView("해당 일정에 대한 권한이 없습니다");
		}

		model.addAttribute("calendar", calendar);

		return "/usr/calendar/modify";
	}

	@RequestMapping("/usr/calendar/doModify")
	@ResponseBody
	public String doModify(int id, String title, String start, String startTime, String end, String endTime, boolean allDay) {

		if (title == null) {
			return Util.jsHistoryBack("제목을 입력해주세요.");
		}
		
		if (start == null || end == null) {
			return Util.jsHistoryBack("날짜를 입력해주세요.");
		}
		
		calendarService.updateCalender(id, rq.getLoginedMemberId(), title, start, startTime, end, endTime, allDay);
		
		return Util.jsReplace("일정이 수정되었습니다.", "list");
	}
	
	@RequestMapping("/usr/calendar/doDelete")
	@ResponseBody
	public String doDelete(int id) {

		Calendar calendar = calendarService.getCalendarByIdAndMemberId(id, rq.getLoginedMemberId());
		
		if (calendar == null) {
			return rq.jsReturnOnView("존재하지 않는 일정입니다.");
		}

		if (rq.getLoginedMemberId() != calendar.getMemberId()) {
			return rq.jsReturnOnView("해당 일정에 대한 권한이 없습니다");
		}

		calendarService.deleteCalendar(id, rq.getLoginedMemberId());

		return Util.jsReplace("일정을 삭제했습니다.", "list");
	}
	
}