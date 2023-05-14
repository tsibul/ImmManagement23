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

    private final InjectionMoldingMachineRepository injectionMoldingMachineRepository;
    private final EquipmentTypeRepository equipmentTypeRepository;
    private final ColorGroupRepository colorGroupRepository;
    private final ColorRepository colorRepository;

    public MainPageController(InjectionMoldingMachineRepository injectionMoldingMachineRepository,
                              EquipmentTypeRepository equipmentTypeRepository,
                              ColorGroupRepository colorGroupRepository,
                              ColorRepository colorRepository) {
        this.injectionMoldingMachineRepository = injectionMoldingMachineRepository;
        this.equipmentTypeRepository = equipmentTypeRepository;
        this.colorGroupRepository = colorGroupRepository;
        this.colorRepository = colorRepository;
    }

    private void populateModel(Model model) {
        List<EquipmentType> equipmentTypeList = equipmentTypeRepository.findAll();
        List<ColorGroup> colorGroupList = colorGroupRepository.findAll();
        model.addAttribute("colorGroups", colorGroupList);
        model.addAttribute("equipmentTypes", equipmentTypeList);
    }

    @GetMapping("/")
    public String mainPage(Model model) {
        populateModel(model);
        return "index";
    }

    @GetMapping("/techcard")
    public String techCard(Model model) {
        populateModel(model);
        return "techcard";
    }

    @GetMapping("/products")
    public String productsPage(Model model) {
        populateModel(model);
        return "products";
    }

    @GetMapping("/equipment")
    public String equipmentPage(Model model) {
        List<InjectionMoldingMachine> immList = injectionMoldingMachineRepository.findAll();
        model.addAttribute("immList", immList);
        populateModel(model);
        return "equipment";
    }

    @GetMapping("/colors")
    public String colorsPage(Model model) {
        populateModel(model);
        return "colors";
    }

}
