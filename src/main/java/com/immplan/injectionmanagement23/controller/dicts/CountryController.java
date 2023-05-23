package com.immplan.injectionmanagement23.controller.dicts;

import com.immplan.injectionmanagement23.controller.BaseController;
import com.immplan.injectionmanagement23.db.equipment.EquipmentTypeRepository;
import com.immplan.injectionmanagement23.db.producer.Country;
import com.immplan.injectionmanagement23.db.producer.repository.CountryRepository;
import com.immplan.injectionmanagement23.db.product.color.ColorGroup;
import com.immplan.injectionmanagement23.db.product.color.repository.ColorGroupRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class CountryController extends BaseController {

    private final CountryRepository countryRepository;

    public CountryController(EquipmentTypeRepository equipmentTypeRepository,
                             ColorGroupRepository colorGroupRepository, CountryRepository countryRepository) {
        super(equipmentTypeRepository, colorGroupRepository);
        this.countryRepository = countryRepository;
    }

    @GetMapping("/country")
    public String getCountry(Model model) {
        List<Country> countries = countryRepository.findCountriesByCountryActiveOrderByCountryName(true);
        populateModel(model);
        model.addAttribute("activePage", "dicts");
        model.addAttribute("countries", countries);
        return "dicts/country";
    }

    @PostMapping("/country/addccountry")
    public String addCountry(@ModelAttribute Country country) {
        countryRepository.save(country);
        return "redirect:/country";
    }

    @GetMapping("/country/{id}/deletecountry")
    public String deleteCountry(@PathVariable int id) {
        ColorGroup colorGroup = colorGroupRepository.findColorGroupByColorGroupId(id);
        colorGroup.setColorGroupActive(false);
        colorGroupRepository.save(colorGroup);
        return "redirect:/country";
    }
}
