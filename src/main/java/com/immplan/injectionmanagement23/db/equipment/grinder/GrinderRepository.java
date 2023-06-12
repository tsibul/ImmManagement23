package com.immplan.injectionmanagement23.db.equipment.grinder;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GrinderRepository extends JpaRepository<Grinder, Long> {
    Grinder findGrinderByEquipmentId(Long equipmentId);
    List<Grinder> findGrinderByEquipmentActiveOrderByInventoryCode(boolean equipmentActive);
}
