package com.koreaIT.webProjectMuk.dao;

import org.apache.ibatis.annotations.Mapper;

import com.koreaIT.webProjectMuk.vo.Calendar;

@Mapper
public interface CalendarDao {

	public Calendar getCalender();
	
}