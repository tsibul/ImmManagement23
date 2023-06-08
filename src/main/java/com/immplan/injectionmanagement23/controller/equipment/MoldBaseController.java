package com.immplan.injectionmanagement23.controller.equipment;

import com.immplan.injectionmanagement23.controller.BaseController;
import com.immplan.injectionmanagement23.db.equipment.equipmentmatching.repository.MoldBaseToInjectionMoldingMachineRepository;
import com.immplan.injectionmanagement23.db.equipment.injectionmoldingmachine.InjectionMoldingMachine;
import com.immplan.injectionmanagement23.db.equipment.injectionmoldingmachine.repository.InjectionMoldingMachineRepository;
import com.immplan.injectionmanagement23.db.equipment.mold.MoldBase;
import com.immplan.injectionmanagement23.db.equipment.mold.repository.MoldBaseRepository;
import com.immplan.injectionmanagement23.db.producer.Producer;
import com.immplan.injectionmanagement23.db.producer.repository.ProducerRepository;
import com.immplan.injectionmanagement23.db.product.color.repository.ColorGroupRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class MoldBaseController extends BaseController {
    private final MoldBaseRepository moldBaseRepository;
    private final ProducerRepository producerRepository;
    private final MoldBaseToInjectionMoldingMachineRepository moldBaseToInjectionMoldingMachineRepository;

    public MoldBaseController(ColorGroupRepository colorGroupRepository,
                              MoldBaseRepository moldBaseRepository, ProducerRepository producerRepository,
                              MoldBaseToInjectionMoldingMachineRepository moldBaseToInjectionMoldingMachineRepository) {
        super(colorGroupRepository);
        this.moldBaseRepository = moldBaseRepository;
        this.producerRepository = producerRepository;
        this.moldBaseToInjectionMoldingMachineRepository = moldBaseToInjectionMoldingMachineRepository;
    }

//TODO solve the problem with "02.01" in getmapping
    @GetMapping("/equipment/02.01")
    public String getMoldBase(Model model) {
        List<MoldBase> moldBases = moldBaseRepository.findMoldBaseByEquipmentActiveOrderByInventoryCode(true);
        List<Producer> producers = producerRepository.findProducerByProducerActiveAndProducerTypeOrderByProducerName(true, "Пресс-формы");
        populateModel(model);
        model.addAttribute("activePage", "equipment");
        model.addAttribute("moldBases", moldBases);
        model.addAttribute("producers", producers);
        return "equipment/mold_base";
    }

    @PostMapping("/equipment/02.01/add_mold_base")
    public String addMoldBase(@ModelAttribute MoldBase moldBase) {
        moldBaseRepository.save(moldBase);
        return "redirect:/mold_base";
    }

    @GetMapping("/equipment/02.01/{id}/delete_mold_base")
    public String deleteColorGroup(@PathVariable int id) {
        MoldBase moldBase = moldBaseRepository.findMoldBaseByEquipmentId((long) id);
        moldBase.setEquipmentActive(false);
        moldBaseRepository.save(moldBase);
        return "redirect:/mold_base";
    }
}
