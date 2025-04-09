package com.mmbusticket.agencysystem.repository;

import com.mmbusticket.agencysystem.entity.RegionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface RegionRepository extends JpaRepository<RegionEntity, Integer>{

}
