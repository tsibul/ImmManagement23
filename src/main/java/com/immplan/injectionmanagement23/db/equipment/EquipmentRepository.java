package com.immplan.injectionmanagement23.db.equipment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {

//    public List<Equipment> findEquipmentByEquipmentType (EquipmentType equipmentType);
}
