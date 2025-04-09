package com.mmbusticket.agencysystem.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import com.mmbusticket.agencysystem.dto.SeatSelectionRequest;
import com.mmbusticket.agencysystem.service.SeatService;

@Controller
public class SeatSelectionController {

    private final SimpMessagingTemplate messagingTemplate;
    private final SeatService seatService;

    public SeatSelectionController(SimpMessagingTemplate messagingTemplate, 
                                 SeatService seatService) {
        this.messagingTemplate = messagingTemplate;
        this.seatService = seatService;
    }

    @MessageMapping("/seats/select")
    public void handleSeatSelection(SeatSelectionRequest message) {
        try {
            Long scheduleId = message.getScheduleId();
            
            if ("select".equals(message.getAction())) {
                seatService.reserveSeat(scheduleId, message.getSeatNumber());
            } else if ("release".equals(message.getAction())) {
                seatService.releaseSeat(scheduleId, message.getSeatNumber());
            }
            
            // Broadcast the update to all subscribers
            messagingTemplate.convertAndSend(
                "/topic/seats/" + scheduleId, 
                message
            );
        } catch (Exception e) {
            // Handle errors
            System.err.println("Error processing seat selection: " + e.getMessage());
        }
    }
}