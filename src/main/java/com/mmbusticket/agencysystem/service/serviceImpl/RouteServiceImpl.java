package com.mmbusticket.agencysystem.service.serviceImpl;

import com.mmbusticket.agencysystem.dto.RegionDto;
import com.mmbusticket.agencysystem.dto.RouteDto;
import com.mmbusticket.agencysystem.entity.RouteEntity;
import com.mmbusticket.agencysystem.entity.ScheduleEntity;
import com.mmbusticket.agencysystem.repository.RegionRepository;
import com.mmbusticket.agencysystem.repository.RouteRepository;
import com.mmbusticket.agencysystem.repository.ScheduleRepository;
import com.mmbusticket.agencysystem.service.RouteService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RouteServiceImpl implements RouteService {

    private RouteRepository routeRepository;
    private ScheduleRepository scheduleRepository;
    
    @Autowired
    public RouteServiceImpl(RouteRepository routeRepository, ScheduleRepository scheduleRepository) {
    	this.routeRepository = routeRepository;
    	this.scheduleRepository = scheduleRepository;
    }

    @Override
    public List<RegionDto> findToRegionsByFromRegion(int fromRegionCode) {
        System.out.println("Fetching routes for fromRegionCode: " + fromRegionCode);

        List<RouteEntity> routes = routeRepository.findByFromRegion_RegionCode(fromRegionCode);

        if (routes.isEmpty()) {
            System.out.println("No routes found for region code: " + fromRegionCode);
            // Return a special DTO indicating no destinations available
           
        }

        return routes.stream()
                .map(route -> new RegionDto(
                    route.getToRegion().getRegionCode(), 
                    route.getToRegion().getRegionName()
                ))
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<RouteDto> findAllRoutes() {
        return routeRepository.findAll().stream()
                .map(route -> new RouteDto(
                        route.getRouteCode(),
                        new RegionDto(
                                route.getFromRegion().getRegionCode(),
                                route.getFromRegion().getRegionName()
                        ),
                        new RegionDto(
                                route.getToRegion().getRegionCode(),
                                route.getToRegion().getRegionName()
                        )
                ))
                .collect(Collectors.toList());
    }
    
    @Override
    public List<ScheduleEntity> searchSchedules(int fromRegionCode, int toRegionCode, LocalDate travelDate) {
        return scheduleRepository.findAvailableSchedules(fromRegionCode, toRegionCode, travelDate);
    }
    
    @Override
    public List<ScheduleEntity> searchSchedulesByRouteCode(int routeCode, LocalDate travelDate) {
        return scheduleRepository.findAvailableSchedules(routeCode, travelDate);
    }

    // Get route details
    @Override
    public RouteEntity getRouteDetails(int routeCode) {
        return routeRepository.findById(routeCode).orElse(null);
    }
}
