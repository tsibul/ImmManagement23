package com.immplan.injectionmanagement23.controller.equipment;


import com.immplan.injectionmanagement23.controller.BaseController;
import com.immplan.injectionmanagement23.db.equipment.injectionmoldingmachine.InjectionMoldingMachine;
import com.immplan.injectionmanagement23.db.equipment.injectionmoldingmachine.repository.InjectionMoldingMachineRepository;
import com.immplan.injectionmanagement23.db.product.color.repository.ColorGroupRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class InjectionMoldingMachineController extends BaseController {

    private final InjectionMoldingMachineRepository injectionMoldingMachineRepository;

    public InjectionMoldingMachineController(InjectionMoldingMachineRepository injectionMoldingMachineRepository) {
        this.injectionMoldingMachineRepository = injectionMoldingMachineRepository;
    }


    @GetMapping("/equipment/01.01")
    public String equipmentPage(Model model) {
        List<InjectionMoldingMachine> immList = injectionMoldingMachineRepository.findAll();
        model.addAttribute("immList", immList);
        populateModel(model);
        model.addAttribute("activePage", "equipment");
        return "equipment/imm";
    }

}
