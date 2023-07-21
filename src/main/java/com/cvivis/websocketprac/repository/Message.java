package com.cvivis.websocketprac.repository;


import lombok.Data;

@Data
public class Message {
    private String sender;
    private String receiver;
    private String data;
}
