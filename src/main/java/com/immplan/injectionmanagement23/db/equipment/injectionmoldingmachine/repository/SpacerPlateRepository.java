package com.immplan.injectionmanagement23.db.equipment.injectionmoldingmachine.repository;

import com.immplan.injectionmanagement23.db.equipment.injectionmoldingmachine.SpacerPlate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpacerPlateRepository extends JpaRepository<SpacerPlate, Long> {
    List<SpacerPlate> findSpacerPlateByEquipmentActiveOrderByEquipmentCode(boolean equipmentActive);
    SpacerPlate findSpacerPlateByEquipmentId(Long equipmentId);
}
