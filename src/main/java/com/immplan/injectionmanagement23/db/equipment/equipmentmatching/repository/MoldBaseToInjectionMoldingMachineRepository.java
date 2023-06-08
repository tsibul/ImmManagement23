package com.immplan.injectionmanagement23.db.equipment.equipmentmatching.repository;

import com.immplan.injectionmanagement23.db.equipment.equipmentmatching.MoldBaseToInjectionMoldingMachine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MoldBaseToInjectionMoldingMachineRepository extends JpaRepository<MoldBaseToInjectionMoldingMachine, Long> {
/*    interface EquipmentIdProjection {
        Long getInjectionMoldingMachineEquipmentId();
    }

 */
//    Integer countByMoldBaseToInjectionMoldingMachineActiveAndMoldBaseEquipmentIdAndInjectionMoldingMachineEquipmentId
//            (boolean active, Long moldBaseId, Long immId);
    List<MoldBaseToInjectionMoldingMachine> findMoldBaseToInjectionMoldingMachineByMoldBaseToInjectionMoldingMachineActive
            (boolean  active);
    //List<MoldBaseToInjectionMoldingMachine>  findMoldBaseToInjectionMoldingMachineByMoldBaseToInjectionMoldingMachineActiveAndMoldBaseEquipmentId(boolean active, Long moldBaseId);

//    List<EquipmentIdProjection>  findMoldBaseToInjectionMoldingMachineByMoldBaseToInjectionMoldingMachineActiveAndMoldBaseEquipmentId(boolean active, Long moldBaseId);

    @Query("SELECT m.injectionMoldingMachine.equipmentId FROM MoldBaseToInjectionMoldingMachine m " +
            "WHERE m.moldBaseToInjectionMoldingMachineActive = true " +
            "AND m.moldBase.equipmentId = :moldBaseId")
    List<Long> findEquipmentIdsByMoldBaseId(@Param("moldBaseId") Long moldBaseId);
}
