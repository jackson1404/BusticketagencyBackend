package com.mmbusticket.agencysystem.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmbusticket.agencysystem.dto.RegionDto;
import com.mmbusticket.agencysystem.service.RegionService;

import io.swagger.v3.oas.annotations.tags.Tag;

	@Tag(name = "Region List", description = "APIs related to Regions")
	@RestController
	@RequestMapping("/AGENCY")
	@CrossOrigin(origins = {"http://localhost:5173", "https://bus-ticket-agency-system.vercel.app",
	"https://80c1-141-11-56-134.ngrok-free.app"})
	public class StartController {

    @Autowired
    private RegionService regionService;

	private static final Logger logger = LoggerFactory.getLogger(StartController.class);

    @GetMapping(value = "/nameList")
    public List<RegionDto> getRegionsList() {

        return regionService.findAllRegions();

    }
    
    

}
