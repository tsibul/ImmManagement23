package com.immplan.injectionmanagement23.db.equipment.grinder;

import com.immplan.injectionmanagement23.db.common.CommonRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GrinderRepository extends JpaRepository<Grinder, Long>, CommonRepository<Grinder> {
    Grinder findGrinderByEquipmentId(Long equipmentId);
    List<Grinder> findGrinderByEquipmentActiveOrderByInventoryCode(boolean equipmentActive);
}
