package com.immplan.injectionmanagement23.controller.materials;

import com.immplan.injectionmanagement23.controller.BaseController;
import com.immplan.injectionmanagement23.db.product.color.repository.ColorGroupRepository;
import com.immplan.injectionmanagement23.db.rawmaterial.MaterialType;
import com.immplan.injectionmanagement23.db.rawmaterial.repository.MaterialTypeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class MaterialTypeController extends BaseController {

    private final MaterialTypeRepository materialTypeRepository;

    public MaterialTypeController(ColorGroupRepository colorGroupRepository, MaterialTypeRepository materialTypeRepository) {
        super(colorGroupRepository);
        this.materialTypeRepository = materialTypeRepository;
    }

    @GetMapping("/materialtypes")
    public String getMaterialType(Model model) {
        populateModel(model);
        List<MaterialType> materialTypes = materialTypeRepository.findMaterialTypeByMaterialActiveOrderByMaterialName(true);
        model.addAttribute("activePage", "materials");
        model.addAttribute("materialTypes", materialTypes);
        return "materials/materialtypes";
    }

    @PostMapping("/materialtypes/addmaterial")
    public String addMaterialType(@ModelAttribute MaterialType materialType) {
        materialTypeRepository.save(materialType);
        return "redirect:/materialtypes";
    }

    @GetMapping("/materialtypes/{id}/deletematerial")
    public String deleteColor(@PathVariable int id) {
        MaterialType materialType = materialTypeRepository.findMaterialTypeByMaterialId(id);
        materialType.setMaterialActive(false);
        materialTypeRepository.save(materialType);
        return "redirect:/materialtypes";
    }
}
