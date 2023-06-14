package com.immplan.injectionmanagement23.db.equipment.air;

import com.immplan.injectionmanagement23.db.common.CommonRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AirEquipmentRepository extends JpaRepository<AirEquipment, Long>, CommonRepository<AirEquipment> {
    AirEquipment findAirEquipmentByEquipmentId(Long equipmentId);
    List<AirEquipment> findAirEquipmentByEquipmentActiveOrderByEquipmentName(boolean equipmentActive);
}
