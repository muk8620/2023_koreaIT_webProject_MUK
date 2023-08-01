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
	
	public ArrayList<Calendar> getCalendarList() {
		return calendarDao.getCalenderList();
	}
	
	

}
