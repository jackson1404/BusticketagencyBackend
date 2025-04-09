package com.mmbusticket.agencysystem.repository;

import com.mmbusticket.agencysystem.dto.RouteDto;
import com.mmbusticket.agencysystem.entity.RouteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<RouteEntity, Integer> {

    List<RouteEntity> findByFromRegion_RegionCode(int fromRegionCode);
}