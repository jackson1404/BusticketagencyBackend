package com.mmbusticket.agencysystem.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mmbusticket.agencysystem.entity.ScheduleEntity;

@Repository
public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Integer> {

    @Query("SELECT s FROM ScheduleEntity s WHERE s.route.routeCode = :routeCode " +
           "AND DATE(s.departureTime) = :travelDate " +
           "AND s.availableSeats > 0 " +
           "ORDER BY s.departureTime")
    List<ScheduleEntity> findAvailableSchedules(int routeCode, LocalDate travelDate);
    
    @Query("SELECT s FROM ScheduleEntity s " +
    	       "JOIN FETCH s.route r " +
    	       "JOIN FETCH r.fromRegion " +
    	       "JOIN FETCH r.toRegion " +
    	       "JOIN FETCH s.bus " +
    	       "WHERE r.fromRegion.regionCode = :fromRegionCode " +
    	       "AND r.toRegion.regionCode = :toRegionCode " +
    	       "AND DATE(s.departureTime) = :travelDate " +
    	       "AND s.availableSeats > 0 " +
    	       "ORDER BY s.departureTime")
    	List<ScheduleEntity> findAvailableSchedules(int fromRegionCode, int toRegionCode, LocalDate travelDate);
}
