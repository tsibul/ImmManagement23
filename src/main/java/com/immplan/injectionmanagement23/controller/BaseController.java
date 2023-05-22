package com.immplan.injectionmanagement23.controller;

import com.immplan.injectionmanagement23.db.equipment.EquipmentType;
import com.immplan.injectionmanagement23.db.equipment.EquipmentTypeRepository;
import com.immplan.injectionmanagement23.db.product.color.ColorGroup;
import com.immplan.injectionmanagement23.db.product.color.repository.ColorGroupRepository;
import org.springframework.ui.Model;

import java.util.List;

public abstract class BaseController {
    protected final EquipmentTypeRepository equipmentTypeRepository;
    protected final ColorGroupRepository colorGroupRepository;

    public BaseController(EquipmentTypeRepository equipmentTypeRepository,
                          ColorGroupRepository colorGroupRepository) {
        this.equipmentTypeRepository = equipmentTypeRepository;
        this.colorGroupRepository = colorGroupRepository;
    }

    protected void populateModel(Model model) {
        List<EquipmentType> equipmentTypeList = equipmentTypeRepository
                .findEquipmentTypeByEquipmentTypeActiveOrderById(true);
        List<ColorGroup> colorGroupList = colorGroupRepository
                .findColorGroupByColorGroupActiveOrderByColorGroupName(true);
        model.addAttribute("colorGroups", colorGroupList);
        model.addAttribute("equipmentTypes", equipmentTypeList);
    }
}