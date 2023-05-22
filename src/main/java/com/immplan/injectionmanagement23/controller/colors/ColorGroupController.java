package com.immplan.injectionmanagement23.controller.colors;

import com.immplan.injectionmanagement23.controller.BaseController;
import com.immplan.injectionmanagement23.db.equipment.EquipmentTypeRepository;
import com.immplan.injectionmanagement23.db.product.color.ColorGroup;
import com.immplan.injectionmanagement23.db.product.color.repository.ColorGroupRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ColorGroupController extends BaseController {

    public ColorGroupController(EquipmentTypeRepository equipmentTypeRepository,
                                ColorGroupRepository colorGroupRepository) {
        super(equipmentTypeRepository, colorGroupRepository);
    }

    @GetMapping("/colorgroup")
    public String getColor(Model model) {
//        long idLong = (long) id;
        populateModel(model);
        model.addAttribute("activePage", "colors");
        return "colorgroup";
    }

    @PostMapping("/colorgroup/addcolor")
    public String addColor(@ModelAttribute ColorGroup colorGroup) {
        colorGroupRepository.save(colorGroup);
        return "redirect:/colorsgroup";
    }

    @GetMapping("/colorgroup/{id}/deletecolorgroup")
    public String deleteColor(@PathVariable int id) {
        ColorGroup colorGroup = colorGroupRepository.findColorGroupByColorGroupId(id);
        colorGroup.setColorGroupActive(false);
        colorGroupRepository.save(colorGroup);
        return "redirect:/colorgroup";
    }
}
