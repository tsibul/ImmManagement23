package com.immplan.injectionmanagement23.controller;


import com.immplan.injectionmanagement23.db.equipment.EquipmentType;
import com.immplan.injectionmanagement23.db.equipment.EquipmentTypeRepository;
import com.immplan.injectionmanagement23.db.equipment.injectionmoldingmachine.InjectionMoldingMachine;
import com.immplan.injectionmanagement23.db.equipment.injectionmoldingmachine.repository.InjectionMoldingMachineRepository;
import com.immplan.injectionmanagement23.db.product.color.ColorGroup;
import com.immplan.injectionmanagement23.db.product.color.repository.ColorGroupRepository;
import com.immplan.injectionmanagement23.db.product.color.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainPageController {

    @Autowired
    private InjectionMoldingMachineRepository injectionMoldingMachineRepository;
    @Autowired
    private EquipmentTypeRepository equipmentTypeRepository;
    @Autowired
    private ColorGroupRepository colorGroupRepository;
    @Autowired
    private ColorRepository colorRepository;

    @GetMapping("/")
    public String mainPage(Model model) {
        List<EquipmentType> equipmentTypeList = equipmentTypeRepository.findAll();
        List<ColorGroup> colorGroupList = colorGroupRepository.findAll();
        model.addAttribute("colorGroups", colorGroupList);
        model.addAttribute("equipmentTypes", equipmentTypeList);
        return "index";
    }

    @GetMapping("/techcard")
    public String techCard(Model model) {
        List<EquipmentType> equipmentTypeList = equipmentTypeRepository.findAll();
        List<ColorGroup> colorGroupList = colorGroupRepository.findAll();
        model.addAttribute("colorGroups", colorGroupList);
        model.addAttribute("equipmentTypes", equipmentTypeList);
        return "techcard";
    }


    @GetMapping("/products")
    public String productsPage(Model model) {
        List<EquipmentType> equipmentTypeList = equipmentTypeRepository.findAll();
        List<ColorGroup> colorGroupList = colorGroupRepository.findAll();
        model.addAttribute("colorGroups", colorGroupList);
        model.addAttribute("equipmentTypes", equipmentTypeList);
        return "products";
    }
    @GetMapping("/equipment")
    public String equipmentPage(Model model) {
        List<InjectionMoldingMachine> immList = injectionMoldingMachineRepository.findAll();
        model.addAttribute("immList", immList);
        List<EquipmentType> equipmentTypeList = equipmentTypeRepository.findAll();
        List<ColorGroup> colorGroupList = colorGroupRepository.findAll();
        model.addAttribute("colorGroups", colorGroupList);
        model.addAttribute("equipmentTypes", equipmentTypeList);
        return "equipment";
    }

    @GetMapping("/colors")
    public String colorsPage (Model model) {
        List<EquipmentType> equipmentTypeList = equipmentTypeRepository.findAll();
        List<ColorGroup> colorGroupList = colorGroupRepository.findAll();
        model.addAttribute("colorGroups", colorGroupList);
        model.addAttribute("equipmentTypes", equipmentTypeList);
        return "colors";
    }

}
