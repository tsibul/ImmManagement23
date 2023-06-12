package com.immplan.injectionmanagement23.db.equipment;

import com.immplan.injectionmanagement23.db.equipment.air.AirEquipment;
import com.immplan.injectionmanagement23.db.equipment.conveior.Conveyor;
import com.immplan.injectionmanagement23.db.equipment.cooling.CoolingEquipment;
import com.immplan.injectionmanagement23.db.equipment.dozer.Dozer;
import com.immplan.injectionmanagement23.db.equipment.dryer.Dryer;
import com.immplan.injectionmanagement23.db.equipment.grinder.Grinder;
import com.immplan.injectionmanagement23.db.equipment.injectionmoldingmachine.InjectionMoldingMachine;
import com.immplan.injectionmanagement23.db.equipment.injectionmoldingmachine.SpacerPlate;
import com.immplan.injectionmanagement23.db.equipment.loader.Loader;
import com.immplan.injectionmanagement23.db.equipment.mold.HydraulicCylinder;
import com.immplan.injectionmanagement23.db.equipment.mold.MoldBase;
import com.immplan.injectionmanagement23.db.equipment.mold.MoldInsert;
import com.immplan.injectionmanagement23.db.equipment.mold.MoldModifier;
import com.immplan.injectionmanagement23.db.equipment.separator.Separator;
import com.immplan.injectionmanagement23.db.equipment.thermocontroller.ThermoController;
import com.immplan.injectionmanagement23.db.equipment.thermostat.Thermostat;

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
    public static LinkedHashMap<String, Class> equipmentTypeClassDict() {
        LinkedHashMap<String, Class> equipmentTypeDict = new LinkedHashMap<>();
        equipmentTypeDict.put("01.01", InjectionMoldingMachine.class);
        equipmentTypeDict.put("01.02", SpacerPlate.class);
        equipmentTypeDict.put("02.01", MoldBase.class);
        equipmentTypeDict.put("02.02", MoldModifier.class);
        equipmentTypeDict.put("02.03", MoldInsert.class);
        equipmentTypeDict.put("02.04", HydraulicCylinder.class);
        equipmentTypeDict.put("03.01", CoolingEquipment.class);
        equipmentTypeDict.put("03.02", AirEquipment.class);
        equipmentTypeDict.put("03.03", Thermostat.class);
        equipmentTypeDict.put("03.04", ThermoController.class);
        equipmentTypeDict.put("03.05", Grinder.class);
        equipmentTypeDict.put("03.06", Dryer.class);
        equipmentTypeDict.put("03.07", Loader.class);
        equipmentTypeDict.put("03.08", Dozer.class);
        equipmentTypeDict.put("03.09", Separator.class);
        equipmentTypeDict.put("03.10", Conveyor.class);
        return equipmentTypeDict;
    }
}
