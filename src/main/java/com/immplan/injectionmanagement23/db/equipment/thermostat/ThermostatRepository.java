package com.immplan.injectionmanagement23.db.equipment.thermostat;

import com.immplan.injectionmanagement23.db.common.CommonEquipmentRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ThermostatRepository extends JpaRepository<Thermostat, Long>, CommonEquipmentRepository<Thermostat> {
    Thermostat findThermostatByEquipmentId(Long equipmentId);
    List<Thermostat> findThermostatByEquipmentActiveOrderByEquipmentCode(boolean equipmentActive);
}
