package com.koreaIT.webProjectMuk.dto;

import java.util.List;

import lombok.Data;

@Data
public class ChatRoomDTO {

    private String roomId;
    private String name;
    private List<String> members;
}