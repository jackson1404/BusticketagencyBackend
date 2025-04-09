package com.mmbusticket.agencysystem.service.serviceImpl;

import com.mmbusticket.agencysystem.dto.RegionDto;

import com.mmbusticket.agencysystem.repository.RegionRepository;
import com.mmbusticket.agencysystem.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    private RegionRepository regionRepository;

    @Override
    public List<RegionDto> findAllRegions() {
        return regionRepository.findAll().stream()
                .map(region -> new RegionDto(region.getRegionCode(), region.getRegionName()))
                .collect(Collectors.toList());
    }
}
