package com.immplan.injectionmanagement23.db.equipment.materialloader;

import com.immplan.injectionmanagement23.db.common.CommonEquipmentRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaterialLoaderRepository extends JpaRepository<MaterialLoader, Long>, CommonEquipmentRepository<MaterialLoader> {
    MaterialLoader findMaterialLoaderByEquipmentId(Long equipmentId);
    List<MaterialLoader>findMaterialLoaderByEquipmentActiveOrderByEquipmentCode(boolean equipmentActive);
}
