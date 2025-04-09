package com.mmbusticket.agencysystem.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RouteDto {

    @JsonProperty("routeId")
    @Getter
    @Setter
    private int routeId;

    @JsonProperty("fromRegion")
    private RegionDto fromRegion;

    @JsonProperty("toRegion")
    private RegionDto toRegion;

    public RouteDto(int routeId, RegionDto fromRegion, RegionDto toRegion) {
        this.routeId = routeId;
        this.fromRegion = fromRegion;
        this.toRegion = toRegion;
    }

    @Override
    public String toString() {
        return "RouteDto{" +
                "routeId=" + routeId +
                ", fromRegion=" + fromRegion +
                ", toRegion=" + toRegion +
                '}';
    }
}
