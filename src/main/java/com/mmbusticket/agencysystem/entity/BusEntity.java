package com.mmbusticket.agencysystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_bus")
public class BusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bus_id")
    private int busId;

    @Column(name = "registration_number", nullable = false, unique = true)
    private String registrationNumber;

    @Column(name = "make_model", nullable = false)
    private String makeModel;

    @Column(name = "capacity", nullable = false)
    private int capacity;

    @Column(name = "bus_type", nullable = false)
    private String busType; // e.g., Standard, Luxury, Sleeper

    @Column(name = "amenities")
    private String amenities; // Comma-separated list

    @OneToMany(mappedBy = "bus")
    private Set<ScheduleEntity> schedules;
}