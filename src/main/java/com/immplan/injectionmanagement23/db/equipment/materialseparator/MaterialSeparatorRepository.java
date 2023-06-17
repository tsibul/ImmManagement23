package com.immplan.injectionmanagement23.db.equipment.materialseparator;

import com.immplan.injectionmanagement23.db.common.CommonEquipmentRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaterialSeparatorRepository extends JpaRepository<MaterialSeparator, Long>, CommonEquipmentRepository<MaterialSeparator> {
    MaterialSeparator findSeparatorByEquipmentId(Long equipmentId);
    List<MaterialSeparator> findSeparatorByEquipmentActiveOrderByEquipmentCode(boolean equipmentActive);
}
