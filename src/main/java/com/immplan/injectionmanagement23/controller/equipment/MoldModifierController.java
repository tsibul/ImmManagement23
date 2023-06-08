package com.immplan.injectionmanagement23.controller.equipment;

import com.immplan.injectionmanagement23.controller.BaseController;
import com.immplan.injectionmanagement23.db.equipment.equipmentmatching.repository.MoldBaseToInjectionMoldingMachineRepository;
import com.immplan.injectionmanagement23.db.equipment.mold.MoldBase;
import com.immplan.injectionmanagement23.db.equipment.mold.MoldModifier;
import com.immplan.injectionmanagement23.db.equipment.mold.repository.MoldBaseRepository;
import com.immplan.injectionmanagement23.db.equipment.mold.repository.MoldModifierRepository;
import com.immplan.injectionmanagement23.db.producer.Producer;
import com.immplan.injectionmanagement23.db.producer.repository.ProducerRepository;
import com.immplan.injectionmanagement23.db.product.color.repository.ColorGroupRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
public class MoldModifierController extends BaseController {
    private final MoldModifierRepository moldModifierRepository;
    private final ProducerRepository producerRepository;

    public MoldModifierController(ColorGroupRepository colorGroupRepository,
                                  MoldModifierRepository moldModifierRepository, ProducerRepository producerRepository) {
        super(colorGroupRepository);
        this.producerRepository = producerRepository;
        this.moldModifierRepository = moldModifierRepository;
    }

    @GetMapping("/equipment/02.02")
    public String getMoldBase(Model model) {
        List<MoldModifier> moldModifiers = moldModifierRepository.findMoldModifierByEquipmentActiveOrderByInventoryCode(true);
        List<Producer> producers = producerRepository.findProducerByProducerActiveAndProducerTypeOrderByProducerName(true, "Пресс-формы");
        populateModel(model);
        model.addAttribute("activePage", "equipment");
        model.addAttribute("moldModifiers", moldModifiers);
        model.addAttribute("producers", producers);
        return "equipment/mold_modifier";
    }

    @PostMapping("/equipment/02.02/add_mold_modifier")
    public String addMoldBase(@ModelAttribute MoldModifier moldModifier,
                              @RequestParam String yearProd, @RequestParam String receive, @RequestParam String invCode) {
        moldModifier.setInventoryCode(invCode);
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date yearProduction = dateformat.parse(yearProd);
            moldModifier.setYearProduction(yearProduction);
        } catch (ParseException ignored) {
        }
        try {
            Date receiveDate = dateformat.parse(receive);
            moldModifier.setReceiveDate(receiveDate);
        } catch (ParseException ignored) {
        }
        moldModifierRepository.save(moldModifier);
        return "redirect:/equipment/02.02";
    }

    @GetMapping("/equipment/02.02/{id}/delete_mold_modifier")
    public String deleteColorGroup(@PathVariable int id) {
        MoldModifier moldModifier = moldModifierRepository.findMoldModifierByEquipmentId((long) id);
        moldModifier.setEquipmentActive(false);
        moldModifierRepository.save(moldModifier);
        return "redirect:/equipment/02.02";
    }
}
