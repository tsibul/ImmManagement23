package com.immplan.injectionmanagement23.controller.dicts;

import com.immplan.injectionmanagement23.controller.BaseController;
import com.immplan.injectionmanagement23.db.equipment.EquipmentTypeRepository;
import com.immplan.injectionmanagement23.db.producer.Country;
import com.immplan.injectionmanagement23.db.producer.Producer;
import com.immplan.injectionmanagement23.db.producer.ProducerType;
import com.immplan.injectionmanagement23.db.producer.repository.CountryRepository;
import com.immplan.injectionmanagement23.db.producer.repository.ProducerRepository;
import com.immplan.injectionmanagement23.db.producer.repository.ProducerTypeRepository;
import com.immplan.injectionmanagement23.db.product.color.repository.ColorGroupRepository;
import com.immplan.injectionmanagement23.db.product.product.Product;
import com.immplan.injectionmanagement23.db.product.product.ProductGroup;
import com.immplan.injectionmanagement23.db.product.product.repository.ProductGroupRepository;
import com.immplan.injectionmanagement23.db.product.product.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class ProducerController extends BaseController {

    private final ProducerTypeRepository producerTypeRepository;
    private final CountryRepository countryRepository;
    private final ProducerRepository producerRepository;

    public ProducerController(EquipmentTypeRepository equipmentTypeRepository,
                              ColorGroupRepository colorGroupRepository, ProducerTypeRepository producerTypeRepository,
                              CountryRepository countryRepository, ProducerRepository producerRepository) {
        super(equipmentTypeRepository, colorGroupRepository);

        this.producerTypeRepository = producerTypeRepository;
        this.countryRepository = countryRepository;
        this.producerRepository = producerRepository;
    }

    @GetMapping("/producer/{countryId}/{producerTypeId}")
    public String getProduct(Model model, @PathVariable int countryId, @PathVariable int producerTypeId) {
        List<Producer> producers;
        if (countryId == 0 && producerTypeId == 0) {
            producers = producerRepository.findProducerByProducerActiveOrderByProducerName(true);
        } else if (countryId != 0 && producerTypeId == 0) {
            producers = producerRepository.
                    findProducerByProducerActiveAndCountryIdOrderByProducerName(true, countryId);
        } else if (countryId == 0) {
            producers = producerRepository.
                    findProducerByProducerActiveAndProducerTypeProducerTypeIdOrderByProducerName(true, producerTypeId);
        } else {
            producers = producerRepository.
                    findProducerByProducerActiveAndCountryIdAndProducerTypeProducerTypeIdOrderByProducerName
                            (true, countryId, producerTypeId);
        }
        List<ProducerType> producerTypes = producerTypeRepository.
                findProducerTypeByProducerTypeActiveOrderByProducerTypeName(true);
        List<Country> countries = countryRepository.findCountriesByCountryActiveOrderByCountryName(true);

        populateModel(model);
        model.addAttribute("activePage", "dicts");
        model.addAttribute("producers", producers);
        model.addAttribute("producerTypes", producerTypes);
        model.addAttribute("countries", countries);
        model.addAttribute("countryId", countryId);
        model.addAttribute("producerTypeId", producerTypeId);
        return "dicts/producer";
    }

    @PostMapping("/producer/add_producer")
    public String addProduct(@ModelAttribute Producer producer,
                             @RequestParam int countryId, @RequestParam int producerTypeId) {
        producerRepository.save(producer);
        return "redirect:/producer/" + countryId + "/" + producerTypeId;
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
