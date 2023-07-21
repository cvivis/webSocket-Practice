package com.cvivis.websocketprac.controller;


import com.cvivis.websocketprac.dto.MessageDto;
import com.cvivis.websocketprac.dto.NormalBidRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@Slf4j
public class WebSocketController {
    private final SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat")
    public void sendMessage(MessageDto messageDto, SimpMessageHeaderAccessor accessor) {
        log.info(messageDto.toString());
        simpMessagingTemplate.convertAndSend("/sub/chat", messageDto);
    }

    @MessageMapping("/normal/{id}")
    public void normalBid(@DestinationVariable("id") Long id, NormalBidRequest normalBidRequest){
        log.info(normalBidRequest.toString());
        simpMessagingTemplate.convertAndSend("/sub/normal/"+id, normalBidRequest);
    }

}
