package com.immplan.injectionmanagement23.db.equipment.mold.repository;

import com.immplan.injectionmanagement23.db.equipment.mold.HydraulicCylinder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HydraulicCilinderRepository extends JpaRepository<HydraulicCylinder, Long> {
    HydraulicCylinder findHydraulicCylinderByEquipmentId(Long equipmentId);
    List<HydraulicCylinder> findHydraulicCylinderByEquipmentActiveOrderByEquipmentCode(boolean equipmentActive);
}
