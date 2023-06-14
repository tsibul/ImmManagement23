package com.immplan.injectionmanagement23.db.equipment.mold.repository;

import com.immplan.injectionmanagement23.db.common.CommonRepository;
import com.immplan.injectionmanagement23.db.equipment.mold.MoldInsert;
import com.immplan.injectionmanagement23.db.equipment.mold.MoldModifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MoldModifierRepository extends JpaRepository <MoldModifier, Long>, CommonRepository<MoldModifier> {
    MoldModifier findMoldModifierByEquipmentId(Long equipmentId);

    List<MoldModifier> findMoldModifierByEquipmentActiveOrderByInventoryCode(boolean equipmentActive);
}
