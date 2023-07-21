package com.cvivis.websocketprac.dto;

import lombok.*;

@Data
@Builder
public class MessageDto {
    private Integer channelId;
    private Integer writerId;
    private String data;
}
