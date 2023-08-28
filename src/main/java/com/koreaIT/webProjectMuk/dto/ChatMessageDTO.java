package com.koreaIT.webProjectMuk.dto;

import lombok.Data;

@Data
public class ChatMessageDTO {

    private int roomId;
    private String regDate;
    private int memberId;
    private String writer;
    private String message;
}