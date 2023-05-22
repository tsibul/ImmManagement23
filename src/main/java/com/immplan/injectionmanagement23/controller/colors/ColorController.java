package com.immplan.injectionmanagement23.controller.colors;

import com.immplan.injectionmanagement23.controller.BaseController;
import com.immplan.injectionmanagement23.db.equipment.EquipmentTypeRepository;
import com.immplan.injectionmanagement23.db.product.color.Color;
import com.immplan.injectionmanagement23.db.product.color.ColorGroup;
import com.immplan.injectionmanagement23.db.product.color.repository.ColorGroupRepository;
import com.immplan.injectionmanagement23.db.product.color.repository.ColorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class ColorController extends BaseController {

    private final ColorRepository colorRepository;

    public ColorController(EquipmentTypeRepository equipmentTypeRepository, ColorRepository colorRepository,
                           ColorGroupRepository colorGroupRepository) {
        super(equipmentTypeRepository, colorGroupRepository);

        this.colorRepository = colorRepository;
    }


    @GetMapping("/colors/{id}")
    public String getColor(@PathVariable("id") int id, Model model) {
//        long idLong = (long) id;
        ColorGroup colorGroup;
        List<Color> colors;
        if(id != 0) {
            colorGroup = colorGroupRepository.findColorGroupByColorGroupId(id);
            colors = colorRepository.findColorByColorActiveAndColorGroupOrderByColorCode(true, colorGroup);
            model.addAttribute("colorGroupId", colorGroup.getColorGroupId());
        }else {
            colors = colorRepository.findColorByColorActiveOrderByColorGroupAscColorCode(true);
            model.addAttribute("colorGroupId", 0);
        }
        populateModel(model);
        model.addAttribute("activePage", "colors");
        model.addAttribute("colors", colors);
        return "colors";
    }

    @PostMapping("/colors/{id}/addcolor")
    public String addColor(@PathVariable("id") int id, @ModelAttribute Color color) {
        colorRepository.save(color);
        return "redirect:/colors/" + id;
    }

    @GetMapping("/colors/{groupId}/{id}/deletecolor")
    public String deleteColor(@PathVariable int groupId, @PathVariable int id) {
        Color color = colorRepository.findColorByColorId(id);
        color.setColorActive(false);
        colorRepository.save(color);
        return "redirect:/colors/" + groupId;
    }
}
