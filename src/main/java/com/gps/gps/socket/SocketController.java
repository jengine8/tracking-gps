package com.gps.gps.socket;

import com.gps.gps.models.GpsTrackModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class SocketController {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @MessageMapping("/track")
    @SendTo("/topic/messages")
    public GpsTrackModel trackMessage(@Payload GpsTrackModel message){
//        System.out.println("Desde trackMessage: "+message);
        return message;
    }


    public void sendTrackingService(GpsTrackModel gpsTrackModel) {
        //Convert spd in m/s a knots
        gpsTrackModel.convertToKnots();
        this.simpMessagingTemplate.convertAndSend("/topic/messages",gpsTrackModel);
    }
}
