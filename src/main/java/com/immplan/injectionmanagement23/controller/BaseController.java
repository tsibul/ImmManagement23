package com.immplan.injectionmanagement23.controller;

import com.immplan.injectionmanagement23.db.equipment.EquipmentKind;
import com.immplan.injectionmanagement23.db.equipment.EquipmentType;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

import static com.immplan.injectionmanagement23.db.equipment.EquipmentKind.equipmentKindDict;
import static com.immplan.injectionmanagement23.db.equipment.EquipmentType.equipmentTypeArrayList;
import static com.immplan.injectionmanagement23.db.equipment.EquipmentTypeRepository.equipmentTotalTypeDict;

public abstract class BaseController {

    public void populateModel(Model model) {
        LinkedHashMap<String, EquipmentType> equipmentTypeList = equipmentTotalTypeDict();
        LinkedHashMap<EquipmentKind, ArrayList<EquipmentType>> equipmentKind = new LinkedHashMap<>();
        equipmentKindDict().forEach((key,value) -> {
            ArrayList<EquipmentType> equipments = equipmentTypeArrayList().stream()
                    .filter(equipment -> equipment.getEquipmentKind().getEquipmentKindId().equals(key))
                    .collect(Collectors.toCollection(ArrayList::new));
            equipmentKind.put(EquipmentKind.equipmentKindDict().get(key), equipments);
        });

        model.addAttribute("equipmentTypes", equipmentTypeList);
        model.addAttribute("equipmentKind", equipmentKind);
    }
}