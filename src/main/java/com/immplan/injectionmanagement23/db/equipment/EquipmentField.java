package com.immplan.injectionmanagement23.db.equipment;

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
