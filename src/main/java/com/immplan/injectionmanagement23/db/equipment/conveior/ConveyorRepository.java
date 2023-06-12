package com.immplan.injectionmanagement23.db.equipment.conveior;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConveyorRepository extends JpaRepository<Conveyor, Long> {
    Conveyor findConveyorByEquipmentId(Long equipmentId);
    List<Conveyor> findConveyorByEquipmentActiveOrderByEquipmentCode(boolean equipmentActive);
}
