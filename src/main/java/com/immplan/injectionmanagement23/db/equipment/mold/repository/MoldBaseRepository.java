package com.immplan.injectionmanagement23.db.equipment.mold.repository;

import com.immplan.injectionmanagement23.db.equipment.mold.MoldBase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MoldBaseRepository extends JpaRepository<MoldBase, Long> {
    MoldBase findMoldBaseByEquipmentId(Long moldBaseId);
    List<MoldBase> findMoldBaseByEquipmentActiveOrderByInventoryCode(boolean equipmentActive);
}
