package com.immplan.injectionmanagement23.controller.products;

import com.immplan.injectionmanagement23.controller.BaseController;
import com.immplan.injectionmanagement23.db.product.color.ColorGroup;
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
    private final ColorGroupRepository colorGroupRepository;

    public ProductGroupController(ProductGroupRepository productGroupRepository, ColorGroupRepository colorGroupRepository) {
        this.productGroupRepository = productGroupRepository;
        this.colorGroupRepository = colorGroupRepository;
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
        List<ColorGroup> colorGroups = colorGroupRepository.findColorGroupByColorGroupActiveOrderByColorGroupName(true);
        populateModel(model);
        model.addAttribute("activePage", "dicts");
        model.addAttribute("productGroups", productGroups);
        model.addAttribute("colorGroups", colorGroups);
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
