package com.immplan.injectionmanagement23.db.equipment;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class EquipmentKind {
    private final String equipmentKindId;
    private final String equipmentKindName;

    public String getEquipmentKindId() {
        return equipmentKindId;
    }

    public String getEquipmentKindName() {
        return equipmentKindName;
    }

    private EquipmentKind(String equipmentKindId, String equipmentKindName) {
        this.equipmentKindId = equipmentKindId;
        this.equipmentKindName = equipmentKindName;
    }

    public static LinkedHashMap<String, EquipmentKind> equipmentKindDict() {
        LinkedHashMap<String, EquipmentKind> equipmentKindDict = new LinkedHashMap<>();
        equipmentKindDict.put("01", new EquipmentKind("01", "Станок/Линия"));
        equipmentKindDict.put("02", new EquipmentKind("02", "Пресс-форма"));
        equipmentKindDict.put("03", new EquipmentKind("03", "Периферия"));
        return equipmentKindDict;
    }
}
