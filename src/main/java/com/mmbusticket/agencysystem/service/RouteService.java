package com.mmbusticket.agencysystem.service;

import com.mmbusticket.agencysystem.dto.RegionDto;
import com.mmbusticket.agencysystem.dto.RouteDto;
import com.mmbusticket.agencysystem.entity.RouteEntity;
import com.mmbusticket.agencysystem.entity.ScheduleEntity;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface RouteService {

    List<RegionDto> findToRegionsByFromRegion(int fromRegionCode);

    List<RouteDto> findAllRoutes();

	RouteEntity getRouteDetails(int routeCode);

	List<ScheduleEntity> searchSchedulesByRouteCode(int routeCode, LocalDate travelDate);

	List<ScheduleEntity> searchSchedules(int fromRegionCode, int toRegionCode, LocalDate travelDate);
}
