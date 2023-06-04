package com.immplan.injectionmanagement23.db.equipment.injectionmoldingmachine.repository;

import com.immplan.injectionmanagement23.db.equipment.injectionmoldingmachine.InjectionMoldingMachine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InjectionMoldingMachineRepository extends JpaRepository<InjectionMoldingMachine, Long> {
    InjectionMoldingMachine findInjectionMoldingMachineByEquipmentId(Long equipmentId);
    List<InjectionMoldingMachine> findInjectionMoldingMachineByEquipmentActiveOrderByInternalNo(boolean equipmentActive);
}
