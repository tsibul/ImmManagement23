package com.immplan.injectionmanagement23.db.equipment;


import java.util.LinkedHashMap;

public class EquipmentKind {
    public static LinkedHashMap<String, String> equipmentKindDict() {
        LinkedHashMap<String, String> equipmentKindDict = new LinkedHashMap<>();
        equipmentKindDict.put("01", "Станок/Линия");
        equipmentKindDict.put("02", "Пресс-форма");
        equipmentKindDict.put("03", "Периферия");
        return equipmentKindDict;
    }
}
