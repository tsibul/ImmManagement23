package com.immplan.injectionmanagement23.controller.dicts;

import com.immplan.injectionmanagement23.controller.BaseController;
import com.immplan.injectionmanagement23.db.equipment.EquipmentTypeRepository;
import com.immplan.injectionmanagement23.db.producer.ProducerType;
import com.immplan.injectionmanagement23.db.producer.repository.ProducerTypeRepository;
import com.immplan.injectionmanagement23.db.product.color.repository.ColorGroupRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class ProducerTypeController extends BaseController {

    private final ProducerTypeRepository producerTypeRepository;

    public ProducerTypeController(EquipmentTypeRepository equipmentTypeRepository,
                                  ColorGroupRepository colorGroupRepository, ProducerTypeRepository producerTypeRepository) {
        super(equipmentTypeRepository, colorGroupRepository);
        this.producerTypeRepository = producerTypeRepository;
    }

    @GetMapping("/producer_type")
    public String getCountry(Model model) {
        List<ProducerType> producerTypes = producerTypeRepository.findProducerTypeByProducerTypeActiveOrderByProducerTypeName(true);
        populateModel(model);
        model.addAttribute("activePage", "dicts");
        model.addAttribute("producerTypes", producerTypes);
        return "dicts/producer_type";
    }

    @PostMapping("/producer_type/add_producer_type")
    public String addCountry(@ModelAttribute ProducerType producerType) {
        producerTypeRepository.save(producerType);
        return "redirect:/producer_type";
    }

    @GetMapping("/producer_type/{id}/delete_producer_type")
    public String deleteCountry(@PathVariable int id) {
        ProducerType producerType = producerTypeRepository.findProducerTypeByProducerTypeId((long) id);
        producerType.setProducerTypeActive(false);
        producerTypeRepository.save(producerType);
        return "redirect:/producer_type";
    }
}
