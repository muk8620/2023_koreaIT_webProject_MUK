package com.koreaIT.webProjectMuk.dto;

import java.util.List;

import lombok.Data;

@Data
public class ChatRoomDTO {

    private int id;
    private String regDate;
    private String name;
    private int creatorId;
    private List<String> members;
}