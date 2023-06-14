package com.immplan.injectionmanagement23.db.equipment.mold.repository;

import com.immplan.injectionmanagement23.db.common.CommonRepository;
import com.immplan.injectionmanagement23.db.equipment.mold.MoldInsert;
import com.immplan.injectionmanagement23.db.equipment.mold.MoldModifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MoldInsertRepository extends JpaRepository<MoldInsert, Long>, CommonRepository<MoldInsert> {
    MoldInsert findMoldInsertByEquipmentIdOrderByEquipmentName(Long equipmentId);
    List<MoldInsert> findMoldInsertByEquipmentActiveOrderByEquipmentName(boolean equipmentActive);
}
