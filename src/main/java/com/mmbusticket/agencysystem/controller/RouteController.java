package com.mmbusticket.agencysystem.controller;

import com.mmbusticket.agencysystem.dto.RegionDto;
import com.mmbusticket.agencysystem.dto.RouteDto;
import com.mmbusticket.agencysystem.entity.RouteEntity;
import com.mmbusticket.agencysystem.entity.ScheduleEntity;
import com.mmbusticket.agencysystem.repository.RouteRepository;
import com.mmbusticket.agencysystem.service.RouteService;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@Tag(name = "Route List", description = "APIs related to route")
@RestController
@RequestMapping("/AGENCY/routes")
@CrossOrigin(origins = {"http://localhost:5173", "https://bus-ticket-agency-system.vercel.app",
		"https://80c1-141-11-56-134.ngrok-free.app"})
public class RouteController {

    @Autowired
    private RouteService routeService;

    @GetMapping({"" ,"/"})
    public List<RouteDto> getAllRoutes(){
        return routeService.findAllRoutes();
    }
    
    @GetMapping(value = "/toDestinations/{fromRegionCode}")
    public List<RegionDto> getToDestinations(@PathVariable int fromRegionCode) {
        return routeService.findToRegionsByFromRegion(fromRegionCode);
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<ScheduleEntity>> searchSchedules(
            @RequestParam int fromRegionCode,
            @RequestParam int toRegionCode,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate travelDate) {
        List<ScheduleEntity> schedules = routeService.searchSchedules(fromRegionCode, toRegionCode, travelDate);
        return ResponseEntity.ok(schedules);
    }

    // Get route details
    @GetMapping("/details/{routeCode}")
    public RouteEntity getRouteDetails(@PathVariable int routeCode) {
        return routeService.getRouteDetails(routeCode);
    }
    
    
}
