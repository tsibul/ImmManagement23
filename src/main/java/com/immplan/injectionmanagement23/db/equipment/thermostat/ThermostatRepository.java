package com.immplan.injectionmanagement23.db.equipment.thermostat;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ThermostatRepository extends JpaRepository<Thermostat, Long> {
    Thermostat findThermostatByEquipmentId(Long equipmentId);
    List<Thermostat> findThermostatByEquipmentActiveOrderByEquipmentCode(boolean equipmentActive);
}
