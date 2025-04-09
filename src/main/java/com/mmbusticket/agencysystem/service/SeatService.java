package com.mmbusticket.agencysystem.service;

import org.springframework.stereotype.Service;

import com.mmbusticket.agencysystem.dto.SeatUpdate;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class SeatService {
    // In-memory storage for demo purposes - replace with database in production
    private final ConcurrentHashMap<String, SeatUpdate> reservations = new ConcurrentHashMap<>();

    public void reserveSeat(Long scheduleId, String seatNumber) {
        String key = scheduleId + "-" + seatNumber;
        reservations.put(key, new SeatUpdate(scheduleId, seatNumber));
    }

    public void releaseSeat(Long scheduleId, String seatNumber) {
        String key = scheduleId + "-" + seatNumber;
        reservations.remove(key);
    }

    public List<SeatUpdate> getReservedSeats(Long scheduleId) {
        return reservations.values().stream()
            .filter(r -> r.getScheduleId().equals(scheduleId))
            .collect(Collectors.toList());
    }
}
