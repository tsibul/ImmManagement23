package com.immplan.injectionmanagement23.db.equipment.mold.repository;

import com.immplan.injectionmanagement23.db.common.CommonRepository;
import com.immplan.injectionmanagement23.db.equipment.mold.HydraulicCylinder;
import com.immplan.injectionmanagement23.db.equipment.mold.MoldInsert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HydraulicCilinderRepository extends JpaRepository<HydraulicCylinder, Long>, CommonRepository<HydraulicCylinder> {
    HydraulicCylinder findHydraulicCylinderByEquipmentId(Long equipmentId);
    List<HydraulicCylinder> findHydraulicCylinderByEquipmentActiveOrderByEquipmentCode(boolean equipmentActive);
}
