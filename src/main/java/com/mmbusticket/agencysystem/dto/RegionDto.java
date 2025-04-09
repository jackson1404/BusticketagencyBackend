package com.mmbusticket.agencysystem.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegionDto {
    @JsonProperty("regionCode")
    @Getter
    @Setter
    private int regionCode;
    
    @JsonProperty("regionName")
    @Getter
    @Setter
    private String regionName;

    public RegionDto(int regionCode, String regionName) {
        this.regionCode = regionCode;
        this.regionName = regionName;
    }
    
    @Override
    public String toString() {
        return "RegionDto{" +
               "regionCode=" + regionCode +
               ", regionName='" + regionName + '\'' +
               '}';
    }
}