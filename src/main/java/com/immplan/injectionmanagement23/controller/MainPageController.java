package com.immplan.injectionmanagement23.controller;


import com.immplan.injectionmanagement23.db.equipment.injectionmoldingmachine.InjectionMoldingMachine;
import com.immplan.injectionmanagement23.db.equipment.injectionmoldingmachine.repository.InjectionMoldingMachineRepository;
import com.immplan.injectionmanagement23.db.product.color.repository.ColorGroupRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainPageController  extends BaseController{

    private final InjectionMoldingMachineRepository injectionMoldingMachineRepository;

    public MainPageController(InjectionMoldingMachineRepository injectionMoldingMachineRepository) {
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


}
