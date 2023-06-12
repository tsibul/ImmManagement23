package com.immplan.injectionmanagement23.db.equipment.dryer;

import com.immplan.injectionmanagement23.db.equipment.dryer.Dryer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DryerRepository extends JpaRepository<Dryer, Long> {
    Dryer findDryerByEquipmentId(Long equipmentId);
    List<Dryer> findDryerByEquipmentActiveOrderByEquipmentCode(boolean equipmentActive);
}
