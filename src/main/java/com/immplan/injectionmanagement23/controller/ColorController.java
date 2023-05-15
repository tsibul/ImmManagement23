package com.immplan.injectionmanagement23.controller;

import com.immplan.injectionmanagement23.db.equipment.EquipmentTypeRepository;
import com.immplan.injectionmanagement23.db.equipment.injectionmoldingmachine.repository.InjectionMoldingMachineRepository;
import com.immplan.injectionmanagement23.db.product.color.Color;
import com.immplan.injectionmanagement23.db.product.color.ColorGroup;
import com.immplan.injectionmanagement23.db.product.color.repository.ColorGroupRepository;
import com.immplan.injectionmanagement23.db.product.color.repository.ColorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Controller
public class ColorController  extends BaseController{

    private final ColorRepository colorRepository;

    public ColorController(EquipmentTypeRepository equipmentTypeRepository, ColorRepository colorRepository,
                              ColorGroupRepository colorGroupRepository) {
        super(equipmentTypeRepository, colorGroupRepository);

        this.colorRepository = colorRepository;
    }


    @GetMapping("/colors/{id}")
    public String getColor(@PathVariable("id") int id, Model model) {
        long idLong = (long) id;
        ColorGroup colorGroup = colorGroupRepository.findColorGroupByColorGroupId(idLong);
        List<Color> colors = colorRepository.findColorByColorGroup(colorGroup);
        populateModel(model);
        model.addAttribute("colorGroup", colorGroup);
        model.addAttribute("activePage", "colors");
        model.addAttribute("colors", colors);
        return "colors";
    }
}
