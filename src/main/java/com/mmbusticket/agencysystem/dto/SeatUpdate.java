package com.mmbusticket.agencysystem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SeatUpdate {
	
	@JsonProperty("scheduleId")
    private Long scheduleId;
	
	@JsonProperty("seatNumber")
    private String seatNumber;
    
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
	
	public SeatUpdate(Long scheduleId, String seatNumber) {
		this.scheduleId = scheduleId;
		this.seatNumber = seatNumber;
	}
    
    
    // Constructors, getters, setters
}