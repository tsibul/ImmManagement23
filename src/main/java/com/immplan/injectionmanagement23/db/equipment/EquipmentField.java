package com.immplan.injectionmanagement23.db.equipment;

import com.immplan.injectionmanagement23.db.equipment.air.AirEquipment;
import com.immplan.injectionmanagement23.db.equipment.conveior.Conveyor;
import com.immplan.injectionmanagement23.db.equipment.cooling.CoolingEquipment;
import com.immplan.injectionmanagement23.db.equipment.dozer.Dozer;
import com.immplan.injectionmanagement23.db.equipment.dryer.Dryer;
import com.immplan.injectionmanagement23.db.equipment.grinder.Grinder;
import com.immplan.injectionmanagement23.db.equipment.materialloader.MaterialLoader;
import com.immplan.injectionmanagement23.db.equipment.materialseparator.MaterialSeparator;
import com.immplan.injectionmanagement23.db.equipment.mold.HydraulicCylinder;
import com.immplan.injectionmanagement23.db.equipment.thermocontroller.ThermoController;
import com.immplan.injectionmanagement23.db.equipment.thermostat.Thermostat;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class EquipmentField {
    private static HashSet buxFields() {
        HashSet<String> bux = new HashSet<>();
        bux.add("equipmentCode");
        bux.add("equipmentProducer");
        bux.add("partNumber");
        bux.add("yearProduction");
        bux.add("receiveDate");
        return bux;
    }

    private static HashSet universalFields() {
        HashSet<String> universal = new HashSet<>();
        universal.add("equipmentName");
        universal.add("inventoryCode");
        universal.add("modifierMountedTo");
        return universal;
    }

    private String engName;
    private String nameRus;
    private String fieldClass;
    private String fieldType;

    public void setEngName(Field field) {
        this.engName = field.getName();
    }

    public String getEngName() {
        return engName;
    }

    public String getNameRus() {
        return nameRus;
    }

    public void setNameRus(Field field) {
        String fieldName = field.getName();
        switch (fieldName) {
            // bux show All equipment
            case "equipmentName" -> nameRus = "название";
            case "inventoryCode" -> nameRus = "инвентарный номер";
            case "equipmentCode" -> nameRus = "код";
            case "equipmentProducer" -> nameRus = "производитель";
            case "partNumber" -> nameRus = "заводской номер";
            case "yearProduction" -> nameRus = "год производства";
            case "receiveDate" -> nameRus = "дата приобретения";
            // tech show InjectionMoldingMachine
            case "internalNo" -> nameRus = "внутренний номер";
            case "clampingForceKn" -> nameRus = "усилие смыкания, кН";
/*          case "plateHeightMm" -> nameRus = "усилие смыкания, кН";
            case "plateHeightMm" -> nameRus = "высота, мм";*/
            case "columnGapMm" -> nameRus = "межколонное расстояние, мм";
            case "columnGapVerticalMm" -> nameRus = "межколонное расстояние вертикальное, мм";
            case "strokeVolumeCm3" -> nameRus = "объем впрыска, см3";
            case "strokeWeightG" -> nameRus = "вес впрыска, г";
            case "heightMm" -> nameRus = "высота, мм";
            case "widthMm" -> nameRus = "ширина, мм";
            case "lengthMm" -> nameRus = "длина, мм";
            case "weightKg" -> nameRus = "вес, кг";
            case "electricHeatCapacityW" -> nameRus = "мощность нагрева, Вт";
            case "electricHydraulicCapacityW" -> nameRus = "электрическая мощность гидравлика, Вт";
            case "maxMoldWeightKg" -> nameRus = "максимальный вес пресс-формы, кг";
            case "minMoldHeightMm" -> nameRus = "минимальная высота пресс-формы, мм";
            case "maxOpeningMm" -> nameRus = "максимальное открытие";
/*          case "movingPlateRingDiameterMm" -> nameRus = "максимальное открытие";
            case "fixedPlateRingDiameterMm" -> nameRus = "максимальное открытие";
            case "numberAirValves" -> nameRus = "максимальное открытие";*/
            case "numberHydraulicValves" -> nameRus = "количество цилиндров";
            case "hydraulicConnectionDiameterMm" -> nameRus = "диаметр подключения гидравлики, мм";
            case "euroMapInterface" -> nameRus = "интерфейс euroMap";
            case "hotRunnersNo" -> nameRus = "количество горячих каналов";
            case "ejectorStrokeMm" -> nameRus = "ход толкателя, мм";
            case "ejectorCentral" -> nameRus = "центральный толкатель";
            case "immType" -> nameRus = "тип запирания";
            // tech show SpacerPlate
            case "plateHeightMm" -> nameRus = "высота, мм";
            case "plateWidthMm" -> nameRus = "ширина, мм";
            case "plateLengthMm" -> nameRus = "длина, мм";
            case "plateWeightKg" -> nameRus = "вес, кг";
            case "plateMountTimeMin" -> nameRus = "время монтажа, мин.";
            case "plateReleaseTimeMin" -> nameRus = "время демонтажа, мин.";
            case "mountingRingDiameterMm" -> nameRus = "диаметр фланца станок, мм";
            case "moldRingDiameterMm" -> nameRus = "диаметр фланца пресс-форма, мм";
            case "plateMounted" -> nameRus = "установлено";
            case "plateMountedTo" -> nameRus = "ТПА";
            // tech show MoldBase
            case "moldBaseWidthMm" -> nameRus = "ширина, мм";
            case "moldBaseLengthMm" -> nameRus = "длина, мм";
            case "ifChangeableModifier" -> nameRus = "сменный модификатор";
            case "hotRunner" -> nameRus = "горячий канал";
            case "movingPlateRingDiameterMm" -> nameRus = "фланец подвижной плиты, мм";
            case "fixedPlateRingDiameterMm" -> nameRus = "фланец неподвижной плиты, мм";
            case "moldMountTimeMin" -> nameRus = "время монтажа, мин";
            case "moldReleaseTimeMin" -> nameRus = "время демонтажа, мин";
            case "moldMounted" -> nameRus = "установлено";
            case "moldMountedTo" -> nameRus = "ТПА";
            // tech show MoldModifier
            case "moldWeightKg" -> nameRus = "вес, кг";
            case "moldHeightMm" -> nameRus = "высота пресс-формы,мм";
            case "ifAir" -> nameRus = "воздух";
            case "ifHydraulic" -> nameRus = "гидравлика";
            case "numberAirValves" -> nameRus = "кол-во клапанов";
            case "numberHydraulicCylinders" -> nameRus = "кол-во цилиндров";
            case "ifChangeableInsert" -> nameRus = "сменная вставка";
            case "modifierMountTime" -> nameRus = "время монтажа, мин";
            case "modifierReleaseTime" -> nameRus = "время демонтажа";
            case "singleModifier" -> nameRus = "единственный модификатор";
            case "modifierMounted" -> nameRus = "установлено";
            case "modifierMountedTo" -> nameRus = "пресс-форма";
            // tech show MoldInsert
            case "numberCavities" -> nameRus = "количество гнезд";
            case "numberWorkingCavities" -> nameRus = "количество рабочих гнезд";
            case "planCycleTime" -> nameRus = "плановое время цикла";
            case "insertMountTime" -> nameRus = "время монтажа, мин";
            case "insertReleaseTime" -> nameRus = "время демонтажа, мин";
            case "singleInsert" -> nameRus = "единственная вставка";
            case "insertMounted" -> nameRus = "установлено";
            case "insertMountedTo" -> nameRus = "модификатор пресс-формы";
            // tech show HydraulicCylinder
            case "strokeLengthMm" -> nameRus = "ход, мм";
            case "cylinderLengthMm" -> nameRus = "длина цилиндра, мм";
            case "cylinderWidthMm" -> nameRus = "ширина цилиндра, мм";
            case "cylinderMounted" -> nameRus = "установлено";
            case "cylinderMountedTo" -> nameRus = "Пресс-форма";
            // tech show CoolingEquipment
            // tech show AirEquipment
            // tech show Thermostat
            // tech show ThermoController
            // tech show Grinder
            // tech show Dryer
            // tech show MaterialLoader
            // tech show Dozer
            // tech show MaterialSeparator
            // tech show Conveyor
            default -> nameRus = fieldName;
        }
    }

    public void setFieldClass(Field field) {
        fieldClass = "unshow";
        String fieldName = field.getName();
        if (buxFields().contains(fieldName)) fieldClass = "bux " + fieldClass;
        else if (universalFields().contains(fieldName)) fieldClass = "";
        else if (nameRus.equals(engName) || nameRus.equals("установлено")) fieldClass = "table-hidden";
        else fieldClass = "tech " + fieldClass;
    }

    public String getFieldClass() {
        return fieldClass;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(Field field) {
        int len = field.getType().getName().toString().split("\\.").length;
        this.fieldType = field.getType().getName().toString().split("\\.")[len-1];
    }

    public static ArrayList<EquipmentField> equipmentFields(Class<?> className){
        java.util.List<Field> equipmentFields = new ArrayList<>(Arrays.asList(className.getDeclaredFields()));
        ArrayList<EquipmentField> equipmentFieldList = new ArrayList<>();
        for (Field field: equipmentFields) {
            EquipmentField newField = new EquipmentField();
            newField.setEngName(field);
            newField.setNameRus(field);
            newField.setFieldClass(field);
            newField.setFieldType(field);
            equipmentFieldList.add(newField);
        }
        return  equipmentFieldList;
    }

   }
