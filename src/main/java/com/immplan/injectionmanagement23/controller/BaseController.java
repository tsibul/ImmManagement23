package com.immplan.injectionmanagement23.controller;

import com.immplan.injectionmanagement23.db.product.color.ColorGroup;
import com.immplan.injectionmanagement23.db.product.color.repository.ColorGroupRepository;
import org.springframework.ui.Model;

import java.util.LinkedHashMap;
import java.util.List;

import static com.immplan.injectionmanagement23.db.equipment.EquipmentType.equipmentTypeDict;

public abstract class BaseController {
    protected final ColorGroupRepository colorGroupRepository;

    public BaseController(ColorGroupRepository colorGroupRepository) {
        this.colorGroupRepository = colorGroupRepository;
    }

    protected void populateModel(Model model) {
        LinkedHashMap<String, String> equipmentTypeList = equipmentTypeDict();
        List<ColorGroup> colorGroupList = colorGroupRepository
                .findColorGroupByColorGroupActiveOrderByColorGroupName(true);
        model.addAttribute("colorGroups", colorGroupList);
        model.addAttribute("equipmentTypes", equipmentTypeList);
    }
}