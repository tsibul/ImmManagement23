package com.immplan.injectionmanagement23.db.equipment.dozer;

import com.immplan.injectionmanagement23.db.common.CommonRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DozerRepository extends JpaRepository<Dozer, Long>, CommonRepository<Dozer> {
    Dozer findDozerByEquipmentId(Long equipmentId);
    List<Dozer> findDozerByEquipmentActiveOrderByEquipmentCode(boolean equipmentActive);
}
