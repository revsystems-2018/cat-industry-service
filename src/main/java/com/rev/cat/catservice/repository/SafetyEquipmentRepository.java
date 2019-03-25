package com.rev.cat.catservice.repository;

import com.lego.care4you.domain.SafetyEquipment;
import com.rev.cat.catservice.repository.bootstrap.GenericRepository;

import java.util.Date;
import java.util.List;


public interface SafetyEquipmentRepository extends GenericRepository<SafetyEquipment> {

    List<SafetyEquipment> findSafetyEquipmentsByCreatedDateOrderByCreatedDateDesc(Date createdDate);
}
