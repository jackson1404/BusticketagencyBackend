package com.mmbusticket.agencysystem.service;

import com.mmbusticket.agencysystem.dto.RegionDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RegionService {

    List<RegionDto> findAllRegions();
}
