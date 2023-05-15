package com.immplan.injectionmanagement23.controller;


import com.immplan.injectionmanagement23.db.equipment.EquipmentType;
import com.immplan.injectionmanagement23.db.equipment.EquipmentTypeRepository;
import com.immplan.injectionmanagement23.db.equipment.injectionmoldingmachine.InjectionMoldingMachine;
import com.immplan.injectionmanagement23.db.equipment.injectionmoldingmachine.repository.InjectionMoldingMachineRepository;
import com.immplan.injectionmanagement23.db.product.color.ColorGroup;
import com.immplan.injectionmanagement23.db.product.color.repository.ColorGroupRepository;
import com.immplan.injectionmanagement23.db.product.color.repository.ColorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainPageController  extends BaseController{

    private final InjectionMoldingMachineRepository injectionMoldingMachineRepository;

    public MainPageController(InjectionMoldingMachineRepository injectionMoldingMachineRepository,
                              EquipmentTypeRepository equipmentTypeRepository,
                              ColorGroupRepository colorGroupRepository) {
        super(equipmentTypeRepository, colorGroupRepository);

        this.injectionMoldingMachineRepository = injectionMoldingMachineRepository;
    }

    @GetMapping("/")
    public String mainPage(Model model) {
        populateModel(model);
        model.addAttribute("activePage", "home");
        return "index";
    }

    @GetMapping("/techcard")
    public String techCard(Model model) {
        populateModel(model);
        model.addAttribute("activePage", "techcard");
        return "techcard";
    }

    @GetMapping("/products")
    public String productsPage(Model model) {
        populateModel(model);
        model.addAttribute("activePage", "products");
        return "products";
    }

    @GetMapping("/equipment")
    public String equipmentPage(Model model) {
        List<InjectionMoldingMachine> immList = injectionMoldingMachineRepository.findAll();
        model.addAttribute("immList", immList);
        populateModel(model);
        model.addAttribute("activePage", "equipment");
        return "equipment";
    }

    @GetMapping("/colors")
    public String colorsPage(Model model) {
        populateModel(model);
        model.addAttribute("activePage", "colors");
        return "colors";
    }

}
