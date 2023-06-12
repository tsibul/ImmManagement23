package com.immplan.injectionmanagement23.db.equipment.dozer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DozerRepository extends JpaRepository<Dozer, Long> {
    Dozer findDozerByEquipmentId(Long equipmentId);
    List<Dozer> findDozerByEquipmentActiveOrderByEquipmentCode(boolean equipmentActive);
}
