package com.mmbusticket.agencysystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_schedule")
public class ScheduleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    @JsonProperty("scheduleId")
    private int scheduleId;

    @ManyToOne
    @JoinColumn(name = "route_code", referencedColumnName = "route_code", nullable = false)
    @JsonProperty("route")
    private RouteEntity route;

    @ManyToOne
    @JoinColumn(name = "bus_id", referencedColumnName = "bus_id", nullable = false)
    @JsonProperty("bus")
    private BusEntity bus;

    @Column(name = "departure_time", nullable = false)
    @JsonProperty("departureTime")
    private LocalDateTime departureTime;

    @Column(name = "arrival_time", nullable = false)
    @JsonProperty("arrivalTime")
    private LocalDateTime arrivalTime;

    @Column(name = "price_local", nullable = false)
    @JsonProperty("priceLocal")
    private double priceLocal;

    @Column(name = "price_foreign", nullable = false)
    @JsonProperty("priceForeign")
    private double priceForeign;

    @Column(name = "available_seats", nullable = false)
    @JsonProperty("availableSeats")
    private int availableSeats;

//    @OneToMany(mappedBy = "schedule")
//    private Set<BookingEntity> bookings;
}