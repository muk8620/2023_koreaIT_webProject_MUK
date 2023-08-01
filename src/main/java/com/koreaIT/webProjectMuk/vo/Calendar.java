package com.koreaIT.webProjectMuk.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Calendar {
	private int id;
	private String regDate;
	private String updateDate;
	private int memberId;
	private int groupId;
	private String title;
	private String writer;
	private String content;
	private String start;
	private String end;
	private boolean allDay;
	private String textColor;
	private String backgroundColor;
	private String borderColor;
	
}
