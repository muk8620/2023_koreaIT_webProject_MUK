package com.koreaIT.webProjectMuk.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.koreaIT.webProjectMuk.vo.Calendar;

@Mapper
public interface CalendarDao {
	
	@Select("""
			SELECT  c.id
					, date_format(`start`, '%Y-%m-%dT%H:%i:%s') AS start
					, date_format(`end`, '%Y-%m-%dT%H:%i:%s') AS end
					, c.allDay
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
	
	@Select("""
			SELECT id
					, regDate 
					, updateDate 
					, memberId 
					, groupId 
					, title 
					, content 
					, SUBSTR(`start`, 1, 10) AS `start` 
					, SUBSTR(`start`, 12, 16) AS `startTime`
					, SUBSTR(`end`, 1, 10) AS `end` 
					, SUBSTR(`end`, 12, 16) AS `endTime`
					, allDay
				FROM calendar
				WHERE id = #{id}
				AND memberId = #{loginedMemberId}
			""")
	public Calendar getCalendarByIdAndMemberId(int id, int loginedMemberId);

	@Insert("""
			INSERT into calendar 
				SET regDate = NOW()
				    , updateDate = NOW()
				    , memberId = #{loginedMemberId}
				    , title = #{title}
				    , `start` = CONCAT(#{start}, ' ', #{startTime})
				    , `end` = CONCAT(#{end}, ' ', #{endTime})
				    , allDay = #{allDay}
			""")
	public void insertCalender(int loginedMemberId, String title, String start, String startTime, String end, String endTime,
			boolean allDay);

	@Delete("""
			DELETE FROM calendar 
				WHERE id = #{id}
				AND memberId = #{loginedMemberId}
			""")
	public void deleteCalendar(int id, int loginedMemberId);
	
	@Update("""
			UPDATE calendar 
				SET updateDate = NOW()
				    , memberId = #{loginedMemberId}
				    , title = #{title}
				    , `start` = CONCAT(#{start}, ' ', #{startTime})
				    , `end` = CONCAT(#{end}, ' ', #{endTime})
				    , allDay = #{allDay}
			    WHERE id = #{id}
			""")
	public void updateCalender(int id, int loginedMemberId, String title, String start, String startTime, String end,
			String endTime, boolean allDay);

}