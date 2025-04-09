package com.mmbusticket.agencysystem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class SeatSelectionRequest {
	
	@JsonProperty("scheduleId")
    private Long scheduleId;
	
	@JsonProperty("seatNumber")
    private String seatNumber;
	
	@JsonProperty("action")
    private String action; // 'select' or 'release'
    
	public Long getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}
	public String getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	
	public SeatSelectionRequest(Long scheduleId, String seatNumber, String action) {
		this.scheduleId = scheduleId;
		this.seatNumber = seatNumber;
		this.action = action;
	}
    
    
    // Getters and setters
}