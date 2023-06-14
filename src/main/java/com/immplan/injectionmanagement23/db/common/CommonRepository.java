package com.immplan.injectionmanagement23.db.common;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommonRepository <T> {
    @Query("SELECT mi FROM #{#entityName} mi WHERE mi.equipmentId = :equipmentId")
    T findEquipmentById(@Param("equipmentId") Long equipmentId);
    @Query("SELECT mi FROM #{#entityName} mi WHERE mi.equipmentActive = :equipmentActive ORDER BY mi.equipmentName")
    List<T> findEquipmentByActiveOrderByName(@Param("equipmentActive") boolean equipmentActive);
}
