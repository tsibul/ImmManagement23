package com.immplan.injectionmanagement23.db.equipment.mold.repository;

import com.immplan.injectionmanagement23.db.common.CommonEquipmentRepository;
import com.immplan.injectionmanagement23.db.equipment.mold.MoldInsert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MoldInsertRepository extends JpaRepository<MoldInsert, Long>, CommonEquipmentRepository<MoldInsert> {
    MoldInsert findMoldInsertByEquipmentIdOrderByEquipmentName(Long equipmentId);
    List<MoldInsert> findMoldInsertByEquipmentActiveOrderByEquipmentName(boolean equipmentActive);
}
