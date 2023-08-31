package com.koreaIT.webProjectMuk.dto;

import lombok.Data;

@Data
public class ChatRoomDTO {

    private int id;
    private String regDate;
    private String name;
    private int creatorId;
}