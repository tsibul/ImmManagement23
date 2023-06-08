package com.immplan.injectionmanagement23.db.equipment;

import java.util.LinkedHashMap;

public class EquipmentType {
    public static LinkedHashMap<String, String> equipmentTypeDict() {
        LinkedHashMap<String, String> equipmentTypeDict = new LinkedHashMap<>();
        equipmentTypeDict.put("01.01", "Термопластавтомат");
        equipmentTypeDict.put("01.02", "Крепежная плита");
        equipmentTypeDict.put("02.01", "Пресс-форма");
        equipmentTypeDict.put("02.02", "Модификатор к пресс-форме");
        equipmentTypeDict.put("02.03", "Вставка в пресс-форму");
        equipmentTypeDict.put("02.04", "Гидроцилиндр");
        equipmentTypeDict.put("03.01", "Охлаждение");
        equipmentTypeDict.put("03.02", "Воздух");
        equipmentTypeDict.put("03.03", "Термостаты");
        equipmentTypeDict.put("03.04", "Термоконтроллеры");
        equipmentTypeDict.put("03.05", "Дробилки");
        equipmentTypeDict.put("03.06", "Сушилки");
        equipmentTypeDict.put("03.07", "Загрузчики");
        equipmentTypeDict.put("03.08", "Дозаторы");
        equipmentTypeDict.put("03.09", "Сепараторы");
        equipmentTypeDict.put("03.10", "Транспортеры");
        return equipmentTypeDict;
    }
}
