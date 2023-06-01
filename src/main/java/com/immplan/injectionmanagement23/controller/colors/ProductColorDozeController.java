package com.immplan.injectionmanagement23.controller.colors;

import com.immplan.injectionmanagement23.controller.BaseController;
import com.immplan.injectionmanagement23.db.equipment.EquipmentTypeRepository;
import com.immplan.injectionmanagement23.db.product.color.Color;
import com.immplan.injectionmanagement23.db.product.color.ProductColorDoze;
import com.immplan.injectionmanagement23.db.product.color.repository.ColorGroupRepository;
import com.immplan.injectionmanagement23.db.product.color.repository.ColorRepository;
import com.immplan.injectionmanagement23.db.product.color.repository.ProductColorDozeRepository;
import com.immplan.injectionmanagement23.db.product.product.ProductGroup;
import com.immplan.injectionmanagement23.db.product.product.repository.ProductGroupRepository;
import com.immplan.injectionmanagement23.db.rawmaterial.MasterBatch;
import com.immplan.injectionmanagement23.db.rawmaterial.MaterialType;
import com.immplan.injectionmanagement23.db.rawmaterial.repository.MasterBatchRepository;
import com.immplan.injectionmanagement23.db.rawmaterial.repository.MaterialTypeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductColorDozeController extends BaseController {

    private final ColorRepository colorRepository;
    private final ProductGroupRepository productGroupRepository;
    private final MasterBatchRepository masterBatchRepository;
    private final MaterialTypeRepository materialTypeRepository;
    private final ProductColorDozeRepository productColorDozeRepository;

    public ProductColorDozeController(EquipmentTypeRepository equipmentTypeRepository, ColorRepository colorRepository,
                                      ColorGroupRepository colorGroupRepository, ProductGroupRepository productGroupRepository,
                                      MasterBatchRepository masterBatchRepository, MaterialTypeRepository materialTypeRepository,
                                      ProductColorDozeRepository productColorDozeRepository) {
        super(equipmentTypeRepository, colorGroupRepository);

        this.colorRepository = colorRepository;
        this.productGroupRepository = productGroupRepository;
        this.masterBatchRepository = masterBatchRepository;
        this.materialTypeRepository = materialTypeRepository;
        this.productColorDozeRepository = productColorDozeRepository;
    }

    @GetMapping("/color_doze/{productGroupsId}")
    public String getColor(@PathVariable int productGroupsId, Model model) {
        List<ProductColorDoze> productColorDozes;
        if (productGroupsId != 0) {
            productColorDozes = productColorDozeRepository.
                    findProductColorDozeByProductColorDozeActiveAndColorColorIdOrderByColorColorCode
                            (true, (long) productGroupsId);
        } else {
            productColorDozes = productColorDozeRepository.
                    findProductColorDozeByProductColorDozeActiveOrderByColorColorCode(true);
        }
        List<Color> colors = colorRepository.findColorByColorActiveOrderByColorGroupAscColorCode(true);
        List<ProductGroup> productGroups = productGroupRepository.
                findProductGroupsByProductGroupActiveOrderByProductGroupName(true);
        List<MasterBatch> masterBatches = masterBatchRepository.getMasterBatchByMaterialActiveOrderByMaterialName(true);
        List<MaterialType> materialTypes = materialTypeRepository.findMaterialTypeByMaterialActiveOrderByMaterialName(true);
        populateModel(model);
        model.addAttribute("activePage", "colors");
        model.addAttribute("productColorDozes", productColorDozes);
        model.addAttribute("colors", colors);
        model.addAttribute("productGroups", productGroups);
        model.addAttribute("masterBatches", masterBatches);
        model.addAttribute("materialTypes", materialTypes);
        model.addAttribute("productGroupsId", productGroupsId);
        return "colors/color_doze";
    }

    @PostMapping("/colors_doze/add_doze")
    public String addColor(@RequestParam int productGroupsId, @ModelAttribute ProductColorDoze productColorDoze) {
        productColorDozeRepository.save(productColorDoze);
        return "redirect:/color_doze/" + productGroupsId;
    }

    @GetMapping("/colors/{id}/delete_doze")
    public String deleteColor(@PathVariable int id, @RequestParam int productGroupsId) {
        ProductColorDoze productColorDoze = productColorDozeRepository.findProductColorDozeByProductColorDozeId((long) id);
        productColorDoze.setProductColorDozeActive(false);
        productColorDozeRepository.save(productColorDoze);
        return "redirect:/color_doze/" + productGroupsId;
    }
}
