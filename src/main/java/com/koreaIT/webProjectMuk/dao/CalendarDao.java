package com.koreaIT.webProjectMuk.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.koreaIT.webProjectMuk.vo.Calendar;

@Mapper
public interface CalendarDao {
	
	@Select("""
			SELECT  c.id
					, date_format(`start`, '%Y-%m-%dT%H:%i:%s') AS start
					, date_format(`end`, '%Y-%m-%dT%H:%i:%s') AS end
					, c.title
					, c.content
					, c.textColor
					, c.backgroundColor
					, c.borderColor
					, m.nickname 
				FROM calendar c
				INNER JOIN `member` m
				ON c.memberId = m.id
				WHERE m.id = #{id}
			""")
	public ArrayList<Calendar> getCalenderList(int id);
	
}