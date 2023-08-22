package com.koreaIT.webProjectMuk.dto;

import lombok.Data;

@Data
public class ChatMessageDTO {

    private String roomId;
    private String regDate;
    private String writer;
    private String message;
}