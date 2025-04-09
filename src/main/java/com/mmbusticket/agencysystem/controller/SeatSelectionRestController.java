package com.mmbusticket.agencysystem.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import com.mmbusticket.agencysystem.dto.*;

import com.mmbusticket.agencysystem.service.SeatService;

@RestController
@CrossOrigin(origins = {"http://localhost:5173", "https://bus-ticket-agency-system.vercel.app"})
@RequestMapping("/AGENCY/seats")
public class SeatSelectionRestController {

    private final SeatService seatService;

    public SeatSelectionRestController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping("/status/{scheduleId}")
    public List<SeatUpdate> getSeatStatus(@PathVariable Long scheduleId) {
        return seatService.getReservedSeats(scheduleId);
    }
}