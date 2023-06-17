package com.immplan.injectionmanagement23.db.equipment.dryer;

import com.immplan.injectionmanagement23.db.common.CommonEquipmentRepository;
import com.immplan.injectionmanagement23.db.equipment.dozer.Dozer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DryerRepository extends JpaRepository<Dryer, Long>, CommonEquipmentRepository<Dozer> {
    Dryer findDryerByEquipmentId(Long equipmentId);
    List<Dryer> findDryerByEquipmentActiveOrderByEquipmentCode(boolean equipmentActive);
}
