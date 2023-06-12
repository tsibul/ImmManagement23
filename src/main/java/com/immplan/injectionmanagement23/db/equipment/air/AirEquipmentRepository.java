package com.immplan.injectionmanagement23.db.equipment.air;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AirEquipmentRepository extends JpaRepository<AirEquipment, Long> {
    AirEquipment findAirEquipmentByEquipmentId(Long equipmentId);
    List<AirEquipment> findAirEquipmentByEquipmentActiveOrderByEquipmentName(boolean equipmentActive);
}
