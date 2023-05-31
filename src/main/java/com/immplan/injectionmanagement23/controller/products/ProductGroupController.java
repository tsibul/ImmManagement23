package com.immplan.injectionmanagement23.controller.products;

import com.immplan.injectionmanagement23.controller.BaseController;
import com.immplan.injectionmanagement23.db.equipment.EquipmentTypeRepository;
import com.immplan.injectionmanagement23.db.product.color.repository.ColorGroupRepository;
import com.immplan.injectionmanagement23.db.product.product.ProductGroup;
import com.immplan.injectionmanagement23.db.product.product.repository.ProductGroupRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class ProductGroupController extends BaseController {

    private final ProductGroupRepository productGroupRepository;

    public ProductGroupController(EquipmentTypeRepository equipmentTypeRepository,
                                  ColorGroupRepository colorGroupRepository,
                                  ProductGroupRepository productGroupRepository) {
        super(equipmentTypeRepository, colorGroupRepository);
        this.productGroupRepository = productGroupRepository;
    }

    @GetMapping("/product_group/{colorGroupsId}")
    public String getColorGroup(Model model, @PathVariable int colorGroupsId) {
        List<ProductGroup> productGroups;
        if (colorGroupsId == 0) {
            productGroups = productGroupRepository.findProductGroupsByProductGroupActiveOrderByProductGroupName(true);
        }
        else {
            productGroups = productGroupRepository.
                    findProductGroupsByProductGroupActiveAndColorGroupColorGroupIdOrderByProductGroupName(true, (long) colorGroupsId);
        }
        populateModel(model);
        model.addAttribute("activePage", "products");
        model.addAttribute("productGroups", productGroups);
        model.addAttribute("colorGroupsId", colorGroupsId);
        return "products/product_group";
    }

    @PostMapping("/product_group/add_product_group")
    public String addColorGroup(@ModelAttribute ProductGroup productGroup, @RequestParam int colorGroupsId) {
        productGroupRepository.save(productGroup);
        return "redirect:/product_group/" + colorGroupsId;
    }

    @GetMapping("/product_group/{id}/delete_product_group")
    public String deleteColorGroup(@PathVariable int id, @RequestParam int colorGroupsId) {
        ProductGroup productGroup = productGroupRepository.findProductGroupsByProductGroupId((long) id);
        productGroup.setProductGroupActive(false);
        productGroupRepository.save(productGroup);
        return "redirect:/product_group/" + colorGroupsId;
    }
}
