package com.immplan.injectionmanagement23.db.equipment;

import com.immplan.injectionmanagement23.db.equipment.air.AirEquipment;
import com.immplan.injectionmanagement23.db.equipment.conveior.Conveyor;
import com.immplan.injectionmanagement23.db.equipment.cooling.CoolingEquipment;
import com.immplan.injectionmanagement23.db.equipment.dozer.Dozer;
import com.immplan.injectionmanagement23.db.equipment.dryer.Dryer;
import com.immplan.injectionmanagement23.db.equipment.grinder.Grinder;
import com.immplan.injectionmanagement23.db.equipment.injectionmoldingmachine.InjectionMoldingMachine;
import com.immplan.injectionmanagement23.db.equipment.injectionmoldingmachine.SpacerPlate;
import com.immplan.injectionmanagement23.db.equipment.materialloader.MaterialLoader;
import com.immplan.injectionmanagement23.db.equipment.materialseparator.MaterialSeparator;
import com.immplan.injectionmanagement23.db.equipment.mold.HydraulicCylinder;
import com.immplan.injectionmanagement23.db.equipment.mold.MoldBase;
import com.immplan.injectionmanagement23.db.equipment.mold.MoldInsert;
import com.immplan.injectionmanagement23.db.equipment.mold.MoldModifier;
import com.immplan.injectionmanagement23.db.equipment.thermocontroller.ThermoController;
import com.immplan.injectionmanagement23.db.equipment.thermostat.Thermostat;

import java.util.ArrayList;

import static com.immplan.injectionmanagement23.db.equipment.EquipmentKind.equipmentKindDict;

public class EquipmentType {
    private final String equipmentTypeId;
    private final String equipmentTypeName;
    private final EquipmentKind equipmentKind;
    private final Class<? extends Equipment> equipmentClass;

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

    EquipmentType(String equipmentTypeId, String equipmentTypeName, String equipmentKindId,
                  Class<? extends Equipment> equipmentClass) {
        this.equipmentTypeId = equipmentTypeId;
        this.equipmentTypeName = equipmentTypeName;
        this.equipmentKind = equipmentKindDict().get(equipmentKindId);
        this.equipmentClass = equipmentClass;
    }
         public static ArrayList<EquipmentType> equipmentTypeArrayList() {
             ArrayList<EquipmentType> equipmentTypeArrayList = new ArrayList<>();
             equipmentTypeArrayList.add(new EquipmentType("01.01", "Термопластавтомат", "01", InjectionMoldingMachine.class));
             equipmentTypeArrayList.add(new EquipmentType("01.02", "Крепежная плита", "01", SpacerPlate.class));
             equipmentTypeArrayList.add(new EquipmentType("02.01", "Пресс-форма", "02", MoldBase.class));
             equipmentTypeArrayList.add(new EquipmentType("02.02", "Модификатор к пресс-форме", "02", MoldModifier.class));
             equipmentTypeArrayList.add(new EquipmentType("02.03", "Вставка в пресс-форму", "02", MoldInsert.class));
             equipmentTypeArrayList.add(new EquipmentType("02.04", "Гидроцилиндр", "02", HydraulicCylinder.class));
             equipmentTypeArrayList.add(new EquipmentType("03.01", "Охлаждение", "03", CoolingEquipment.class));
             equipmentTypeArrayList.add(new EquipmentType("03.02", "Воздух", "03", AirEquipment.class));
             equipmentTypeArrayList.add(new EquipmentType("03.03", "Термостаты", "03", Thermostat.class));
             equipmentTypeArrayList.add(new EquipmentType("03.04", "Термоконтроллеры", "03", ThermoController.class));
             equipmentTypeArrayList.add(new EquipmentType("03.05", "Дробилки", "03", Grinder.class));
             equipmentTypeArrayList.add(new EquipmentType("03.06", "Сушилки", "03", Dryer.class));
             equipmentTypeArrayList.add(new EquipmentType("03.07", "Загрузчики", "03", MaterialLoader.class));
             equipmentTypeArrayList.add(new EquipmentType("03.08", "Дозаторы", "03", Dozer.class));
             equipmentTypeArrayList.add(new EquipmentType("03.09", "Сепараторы", "03", MaterialSeparator.class));
             equipmentTypeArrayList.add(new EquipmentType("03.10", "Транспортеры", "03", Conveyor.class));
             return equipmentTypeArrayList;
         }
}
