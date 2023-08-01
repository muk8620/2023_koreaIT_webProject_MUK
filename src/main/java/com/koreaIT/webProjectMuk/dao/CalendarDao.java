package com.koreaIT.webProjectMuk.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.koreaIT.webProjectMuk.vo.Calendar;

@Mapper
public interface CalendarDao {
	
	@Select("""
			SELECT  id
					, date_format(`start`, '%Y-%m-%dT%H:%i:%s') AS start
					, date_format(`end`, '%Y-%m-%dT%H:%i:%s') AS end
					, title
					, allday
					, content
					, textColor
					, backgroundColor
					, borderColor
				FROM calendar
			""")
	public ArrayList<Calendar> getCalenderList();
	
}