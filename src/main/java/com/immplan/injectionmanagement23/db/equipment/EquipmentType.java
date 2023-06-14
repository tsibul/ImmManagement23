package com.immplan.injectionmanagement23.db.equipment;

import org.springframework.data.jpa.repository.JpaRepository;

import static com.immplan.injectionmanagement23.db.equipment.EquipmentKind.equipmentKindDict;

public class EquipmentType {
    private final String equipmentTypeId;
    private final String equipmentTypeName;
    private final EquipmentKind equipmentKind;
    private final Class<? extends Equipment> equipmentClass;
    private final JpaRepository<?, Long> equipmentRepository;

    public String getEquipmentTypeId() {
        return equipmentTypeId;
    }

    public String getEquipmentTypeName() {
        return equipmentTypeName;
    }

    public EquipmentKind getEquipmentKind() {
        return equipmentKind;
    }

    public Class<? extends Equipment> getEquipmentClass() {
        return equipmentClass;
    }

    public JpaRepository<?, Long> getEquipmentRepository() {
        return equipmentRepository;
    }

    private EquipmentType(String equipmentTypeId, String equipmentTypeName, String equipmentKindId,
                          JpaRepository<?, Long> equipmentRepository, Class<? extends Equipment> equipmentClass) {
        this.equipmentTypeId = equipmentTypeId;
        this.equipmentTypeName = equipmentTypeName;
        this.equipmentKind = equipmentKindDict().get(equipmentKindId);
        this.equipmentRepository = equipmentRepository;
        this.equipmentClass = equipmentClass;
    }
}
