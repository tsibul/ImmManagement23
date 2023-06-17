package com.immplan.injectionmanagement23.controller.colors;

import com.immplan.injectionmanagement23.controller.BaseController;
import com.immplan.injectionmanagement23.db.product.color.ColorGroup;
import com.immplan.injectionmanagement23.db.product.color.repository.ColorGroupRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ColorGroupController extends BaseController {
    private final  ColorGroupRepository colorGroupRepository;

    public ColorGroupController(ColorGroupRepository colorGroupRepository) {
        this.colorGroupRepository = colorGroupRepository;
    }

    @GetMapping("/colorgroups")
    public String getColorGroup(Model model) {
//        long idLong = (long) id;
        populateModel(model);
        model.addAttribute("activePage", "dicts");
        return "colors/colorgroups";
    }

    @PostMapping("/colorgroups/addcolorgroup")
    public String addColorGroup(@ModelAttribute ColorGroup colorGroup) {
        colorGroupRepository.save(colorGroup);
        return "redirect:/colorgroups";
    }

    @GetMapping("/colorgroups/{id}/deletecolorgroup")
    public String deleteColorGroup(@PathVariable int id) {
        ColorGroup colorGroup = colorGroupRepository.findColorGroupByColorGroupId(id);
        colorGroup.setColorGroupActive(false);
        colorGroupRepository.save(colorGroup);
        return "redirect:/colorgroups";
    }
}
