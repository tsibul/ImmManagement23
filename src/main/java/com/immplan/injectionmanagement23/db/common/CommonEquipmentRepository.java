package com.immplan.injectionmanagement23.db.common;

import com.immplan.injectionmanagement23.db.equipment.Equipment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommonEquipmentRepository<T> {
 /*   @Query("SELECT mi FROM #{#entityName} mi " +
            "WHERE mi.equipmentKind.equipmentKindId = :equipmentKindId")
    List<T> findEquipmentByKind(@Param("equipmentKindId") String equipmentKindId);

  */

    @Query("SELECT mi FROM #{#entityName} mi " +
            "WHERE mi.equipmentActive = :equipmentActive " +
            "ORDER BY mi.inventoryCode, mi.equipmentName")
    List<T> findEquipmentByActiveOrderByName(@Param("equipmentActive") boolean equipmentActive);
}
