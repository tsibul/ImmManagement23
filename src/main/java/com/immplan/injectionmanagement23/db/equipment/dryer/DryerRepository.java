package com.immplan.injectionmanagement23.db.equipment.dryer;

import com.immplan.injectionmanagement23.db.common.CommonRepository;
import com.immplan.injectionmanagement23.db.equipment.dozer.Dozer;
import com.immplan.injectionmanagement23.db.equipment.dryer.Dryer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DryerRepository extends JpaRepository<Dryer, Long>, CommonRepository<Dozer> {
    Dryer findDryerByEquipmentId(Long equipmentId);
    List<Dryer> findDryerByEquipmentActiveOrderByEquipmentCode(boolean equipmentActive);
}
