package com.gps.gps.controller;

import com.gps.gps.models.GpsTrackModel;
import com.gps.gps.socket.SocketController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/gps")
public class GpsController {
    @Autowired
    private SocketController socketController;
    @CrossOrigin("*")
    @PostMapping("/track")
    public ResponseEntity<?> processGpsInformation (@RequestBody GpsTrackModel gpsTrackModel){
        //System.out.println("Request Body: " + gpsTrackModel);
         socketController.sendTrackingService(gpsTrackModel);

        return ResponseEntity.status(HttpStatus.OK).body(true);

    }
}
