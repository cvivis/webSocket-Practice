package com.cvivis.websocketprac.dto;


import lombok.Data;

@Data
public class NormalBidResponse {
    private Long id;
    private Long memberId;
    private Integer price;
}
