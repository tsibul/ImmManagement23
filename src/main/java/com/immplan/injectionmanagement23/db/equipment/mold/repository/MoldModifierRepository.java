package com.immplan.injectionmanagement23.db.equipment.mold.repository;

import com.immplan.injectionmanagement23.db.equipment.mold.MoldModifier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MoldModifierRepository extends JpaRepository <MoldModifier, Long> {
    MoldModifier findMoldModifierByEquipmentId(Long equipmentId);
    List<MoldModifier> findMoldModifierByEquipmentActiveOrderByInventoryCode(boolean equipmentActive);
}
