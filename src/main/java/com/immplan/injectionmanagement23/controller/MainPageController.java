package com.immplan.injectionmanagement23.controller;


import com.immplan.injectionmanagement23.db.equipment.injectionmoldingmachine.InjectionMoldingMachine;
import com.immplan.injectionmanagement23.db.equipment.injectionmoldingmachine.repository.InjectionMoldingMachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainPageController {

    @GetMapping("/")
    public String mainPage() {
        return "index";
    }

    @GetMapping("/techcard")
    public String techCard() {
        return "techcard";
    }


    @GetMapping("/products")
    public String productsPage() {
        return "products";
    }

    @Autowired
    private InjectionMoldingMachineRepository injectionMoldingMachineRepository;
    @GetMapping("/equipment")
    public String equipmentPage(Model model) {
        List<InjectionMoldingMachine> immList = injectionMoldingMachineRepository.findAll();
        model.addAttribute("immList", immList);
        return "equipment";
    }

    @GetMapping("/colors")
    public String colorsPage() {
        return "colors";
    }

}
