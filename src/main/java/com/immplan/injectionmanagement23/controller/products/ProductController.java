package com.immplan.injectionmanagement23.controller.products;

import com.immplan.injectionmanagement23.controller.BaseController;
import com.immplan.injectionmanagement23.db.equipment.EquipmentTypeRepository;
import com.immplan.injectionmanagement23.db.product.product.Product;
import com.immplan.injectionmanagement23.db.product.product.ProductGroup;
import com.immplan.injectionmanagement23.db.product.product.repository.ProductGroupRepository;
import com.immplan.injectionmanagement23.db.product.product.repository.ProductRepository;
import com.immplan.injectionmanagement23.db.product.color.repository.ColorGroupRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class ProductController extends BaseController {

    private final ProductRepository productRepository;
    private final ProductGroupRepository productGroupRepository;

    public ProductController(EquipmentTypeRepository equipmentTypeRepository,
                             ColorGroupRepository colorGroupRepository, ProductRepository productRepository,
                             ProductGroupRepository productGroupRepository) {
        super(equipmentTypeRepository, colorGroupRepository);

        this.productRepository = productRepository;
        this.productGroupRepository = productGroupRepository;
    }

    @GetMapping("/products/{colorGroupId}/{productGroupId}")
    public String getProduct(Model model, @PathVariable int colorGroupId, @PathVariable int productGroupId) {
        List<Product> products;
        if (colorGroupId == 0 && productGroupId == 0) {
            products = productRepository.findProductByProductActiveOrderByProductCode(true);
        } else if (colorGroupId != 0 && productGroupId == 0) {
            products = productRepository.
                    findProductByProductActiveAndColorGroupColorGroupIdOrderByProductCode(true, (long) colorGroupId);
        } else if (colorGroupId == 0) {
            products = productRepository.
                    findProductByProductActiveAndAndProductGroupProductGroupIdOrderByProductCode(true, (long) productGroupId);
        } else {
            products = productRepository.
                    findProductByProductActiveAndColorGroupColorGroupIdAndProductGroupProductGroupIdOrderByProductCode
                            (true, (long) colorGroupId, (long) productGroupId);
        }
        List<ProductGroup> productGroups = productGroupRepository.
                findProductGroupsByProductGroupActiveOrderByProductGroupName(true);

        populateModel(model);
        model.addAttribute("activePage", "products");
        model.addAttribute("products", products);
        model.addAttribute("productGroups", productGroups);
        model.addAttribute("productGroupsId", productGroupId);
        model.addAttribute("colorGroupsId", colorGroupId);
        return "products";
    }

    @PostMapping("/products/addproduct")
    public String addProduct(@ModelAttribute Product product,
                             @RequestParam int colorGroupsId, @RequestParam int productGroupsId) {
        productRepository.save(product);
        return "redirect:/products/" + colorGroupsId + "/" + productGroupsId;
    }

    @GetMapping("/products/{id}/deleteproduct")
    public String deleteProduct(@PathVariable int id,
                                @RequestParam int colorGroupsId, @RequestParam int productGroupsId) {
        Product product = productRepository.findProductByProductId(id);
        product.setProductActive(false);
        productRepository.save(product);
        return "redirect:/products/" + colorGroupsId + "/" + productGroupsId;
    }
}
