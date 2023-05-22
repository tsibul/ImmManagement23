package com.immplan.injectionmanagement23.db.equipment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipmentTypeRepository extends JpaRepository<EquipmentType, Long> {
    List<EquipmentType> findAllByIdIsNotNull();
    List<EquipmentType> findEquipmentTypeByEquipmentTypeActiveOrderById(boolean equipmentTypeActive);
}
