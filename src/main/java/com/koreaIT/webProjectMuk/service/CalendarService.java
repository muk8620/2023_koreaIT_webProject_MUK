package com.koreaIT.webProjectMuk.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreaIT.webProjectMuk.dao.CalendarDao;
import com.koreaIT.webProjectMuk.vo.Calendar;

@Service
public class CalendarService {
	private CalendarDao calendarDao;
	
	@Autowired
	public CalendarService(CalendarDao calendarDao) {
		this.calendarDao = calendarDao;
	}
	
	public ArrayList<Calendar> getCalendarList(int id) {
		return calendarDao.getCalenderList(id);
	}

	public Calendar getCalendarByIdAndMemberId(int id, int loginedMemberId) {
		return calendarDao.getCalendarByIdAndMemberId(id, loginedMemberId);
	}
	
	public void insertCalender(int loginedMemberId, String title, String start, String startTime, String end, String endTime,
			boolean allDay) {
		calendarDao.insertCalender(loginedMemberId, title, start, startTime, end, endTime, allDay);
	}

	public void deleteCalendar(int id, int loginedMemberId) {
		calendarDao.deleteCalendar(id, loginedMemberId);
	}

	public void updateCalender(int id, int loginedMemberId, String title, String start, String startTime, String end,
			String endTime, boolean allDay) {
		calendarDao.updateCalender(id, loginedMemberId, title, start, startTime, end, endTime, allDay);
	}

	
}
