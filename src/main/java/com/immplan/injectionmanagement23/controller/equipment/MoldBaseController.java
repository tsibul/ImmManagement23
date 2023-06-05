package com.immplan.injectionmanagement23.controller.equipment;

import com.immplan.injectionmanagement23.controller.BaseController;
import com.immplan.injectionmanagement23.db.equipment.EquipmentTypeRepository;
import com.immplan.injectionmanagement23.db.equipment.injectionmoldingmachine.InjectionMoldingMachine;
import com.immplan.injectionmanagement23.db.equipment.injectionmoldingmachine.repository.InjectionMoldingMachineRepository;
import com.immplan.injectionmanagement23.db.equipment.mold.MoldBase;
import com.immplan.injectionmanagement23.db.equipment.mold.repository.MoldBaseRepository;
import com.immplan.injectionmanagement23.db.product.color.repository.ColorGroupRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class MoldBaseController extends BaseController {
    private final MoldBaseRepository moldBaseRepository;
    private final InjectionMoldingMachineRepository injectionMoldingMachineRepository;

    public MoldBaseController(EquipmentTypeRepository equipmentTypeRepository,
                              ColorGroupRepository colorGroupRepository,
                              InjectionMoldingMachineRepository injectionMoldingMachineRepository,
                              MoldBaseRepository moldBaseRepository) {
        super(equipmentTypeRepository, colorGroupRepository);
        this.moldBaseRepository = moldBaseRepository;
        this.injectionMoldingMachineRepository = injectionMoldingMachineRepository;
    }

//TODO solve the problem with "3" in getmapping
    @GetMapping("/equipment/3")
    public String getMoldBase(Model model) {
        List<InjectionMoldingMachine> injectionMoldingMachines = injectionMoldingMachineRepository.
                findInjectionMoldingMachineByEquipmentActiveOrderByInternalNo(true);
        List<MoldBase> moldBases = moldBaseRepository.findMoldBaseByEquipmentActiveOrderByInventoryCode(true);
        populateModel(model);
        model.addAttribute("activePage", "equipment");
        model.addAttribute("iMM", injectionMoldingMachines);
        model.addAttribute("moldBases", moldBases);
        return "equipment/mold_base";
    }

    @PostMapping("/equipment/3/add_mold_base")
    public String addMoldBase(@ModelAttribute MoldBase moldBase) {
        moldBaseRepository.save(moldBase);
        return "redirect:/mold_base";
    }

    @GetMapping("/equipment/3/{id}/delete_mold_base")
    public String deleteColorGroup(@PathVariable int id) {
        MoldBase moldBase = moldBaseRepository.findMoldBaseByEquipmentId((long) id);
        moldBase.setEquipmentActive(false);
        moldBaseRepository.save(moldBase);
        return "redirect:/mold_base";
    }
}
