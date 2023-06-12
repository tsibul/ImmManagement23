package com.immplan.injectionmanagement23.db.equipment.cooling;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoolingEquipmentRepository extends JpaRepository<CoolingEquipment, Long> {
    CoolingEquipment findCoolingEquipmentByEquipmentId(Long equipmentId);
    List<CoolingEquipment> findCoolingEquipmentByEquipmentActiveOrderByEquipmentName(boolean equipmentActive);
}
