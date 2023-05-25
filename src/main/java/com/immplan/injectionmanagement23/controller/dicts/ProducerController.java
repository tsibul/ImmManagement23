package com.immplan.injectionmanagement23.controller.dicts;

import com.immplan.injectionmanagement23.controller.BaseController;
import com.immplan.injectionmanagement23.db.equipment.EquipmentTypeRepository;
import com.immplan.injectionmanagement23.db.producer.Country;
import com.immplan.injectionmanagement23.db.producer.Producer;
import com.immplan.injectionmanagement23.db.producer.repository.CountryRepository;
import com.immplan.injectionmanagement23.db.producer.repository.ProducerRepository;
import com.immplan.injectionmanagement23.db.product.color.repository.ColorGroupRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

import static com.immplan.injectionmanagement23.db.producer.ProducerType.producerTypeDict;


@Controller
public class ProducerController extends BaseController {

    private final CountryRepository countryRepository;
    private final ProducerRepository producerRepository;

    public ProducerController(EquipmentTypeRepository equipmentTypeRepository,
                              ColorGroupRepository colorGroupRepository,
                              CountryRepository countryRepository, ProducerRepository producerRepository) {
        super(equipmentTypeRepository, colorGroupRepository);

        this.countryRepository = countryRepository;
        this.producerRepository = producerRepository;
    }

    @GetMapping("/producer/{countryId}/{producerTypesId}")
    public String getProduct(Model model, @PathVariable int countryId, @PathVariable int producerTypesId) {
        List<Producer> producers;
        if (countryId == 0 && producerTypesId == 0) {
            producers = producerRepository.findProducerByProducerActiveOrderByProducerName(true);
        } else if (countryId != 0 && producerTypesId == 0) {
            producers = producerRepository.
                    findProducerByProducerActiveAndCountryIdOrderByProducerName(true, countryId);
        } else if (countryId == 0) {
            producers = producerRepository.
                    findProducerByProducerActiveAndProducerTypeOrderByProducerName(true, producerTypeDict().get(producerTypesId));
        } else {
            producers = producerRepository.
                    findProducerByProducerActiveAndCountryIdAndProducerTypeOrderByProducerName
                            (true, countryId, producerTypeDict().get(producerTypesId));
        }
        HashMap<Integer, String> producerTypes = producerTypeDict();
        List<Country> countries = countryRepository.findCountriesByCountryActiveOrderByCountryName(true);

        populateModel(model);
        model.addAttribute("activePage", "dicts");
        model.addAttribute("producers", producers);
        model.addAttribute("producerTypes", producerTypes);
        model.addAttribute("countries", countries);
        model.addAttribute("countryId", countryId);
        model.addAttribute("producerTypesId", producerTypesId);
        return "dicts/producer";
    }

    @PostMapping("/producer/add_producer")
    public String addProduct(@ModelAttribute Producer producer,
                             @RequestParam int countryId, @RequestParam int producerTypesId) {
        producer.setProducerType(producerTypeDict().get(producer.getProducerTypeId()));
        producerRepository.save(producer);
        return "redirect:/producer/" + countryId + "/" + producerTypesId;
    }

    @GetMapping("/producer/{id}/delete_producer")
    public String deleteProduct(@PathVariable int id,
                                @RequestParam int countryId, @RequestParam int producerTypeId) {
        Producer producer = producerRepository.findProducerById((long) id);
        producer.setProducerActive(false);
        producerRepository.save(producer);
        return "redirect:/producer/" + countryId + "/" + producerTypeId;
    }
}
