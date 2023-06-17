package com.immplan.injectionmanagement23.db.equipment.thermocontroller;

import com.immplan.injectionmanagement23.db.common.CommonEquipmentRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ThermoControllerRepository extends JpaRepository<ThermoController, Long>, CommonEquipmentRepository<ThermoController> {
    ThermoController findThermoControllerByEquipmentId(Long equipmentId);
    List<ThermoController> findThermoControllerByEquipmentActiveOrderByEquipmentCode(boolean equipmenActive);
}
