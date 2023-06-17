package com.immplan.injectionmanagement23.db.equipment.mold.repository;

import com.immplan.injectionmanagement23.db.common.CommonEquipmentRepository;
import com.immplan.injectionmanagement23.db.equipment.mold.MoldBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MoldBaseRepository extends JpaRepository<MoldBase, Long>, CommonEquipmentRepository<MoldBase> {
    MoldBase findMoldBaseByEquipmentId(Long moldBaseId);
    List<MoldBase> findMoldBaseByEquipmentActiveOrderByInventoryCode(boolean equipmentActive);
}
