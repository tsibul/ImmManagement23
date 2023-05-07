package com.immplan.injectionmanagement23.db.equipment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface EquipmentTypeRepository extends JpaRepository<EquipmentType, Long> {
    ArrayList<EquipmentType> findAllByIdIsNotNull();
}
