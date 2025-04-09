package com.mmbusticket.agencysystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_route")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RouteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "route_code")
    private int routeCode;

    @ManyToOne
    @JoinColumn(name = "from_region_code", referencedColumnName = "region_code", nullable = false)
    private RegionEntity fromRegion;

    @ManyToOne
    @JoinColumn(name = "to_region_code", referencedColumnName = "region_code", nullable = false)
    private RegionEntity toRegion;


    public int getRouteCode() {
        return routeCode;
    }

    public RegionEntity getToRegion() {
        return toRegion;
    }

    public RegionEntity getFromRegion() {
        return fromRegion;
    }

    public void setRouteCode(int routeCode) {
        this.routeCode = routeCode;
    }

    public void setFromRegion(RegionEntity fromRegion) {
        this.fromRegion = fromRegion;
    }

    public void setToRegion(RegionEntity toRegion) {
        this.toRegion = toRegion;
    }
}



