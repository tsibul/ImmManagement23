package com.immplan.injectionmanagement23.controller.dicts;

import com.immplan.injectionmanagement23.controller.BaseController;
import com.immplan.injectionmanagement23.db.equipment.EquipmentTypeRepository;
import com.immplan.injectionmanagement23.db.product.color.repository.ColorGroupRepository;
import org.springframework.stereotype.Controller;


@Controller
public class ProducerTypeController extends BaseController {

//    private final ProducerTypeRepository producerTypeRepository;

    public ProducerTypeController(EquipmentTypeRepository equipmentTypeRepository,
                                  ColorGroupRepository colorGroupRepository) {
        super(equipmentTypeRepository, colorGroupRepository);
//        this.producerTypeRepository = producerTypeRepository;
    }
/*
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

     */
}
