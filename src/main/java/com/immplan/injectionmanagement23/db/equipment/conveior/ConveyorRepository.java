package com.immplan.injectionmanagement23.db.equipment.conveior;

import com.immplan.injectionmanagement23.db.common.CommonEquipmentRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConveyorRepository extends JpaRepository<Conveyor, Long>, CommonEquipmentRepository<Conveyor> {
    Conveyor findConveyorByEquipmentId(Long equipmentId);
    List<Conveyor> findConveyorByEquipmentActiveOrderByEquipmentCode(boolean equipmentActive);
}
