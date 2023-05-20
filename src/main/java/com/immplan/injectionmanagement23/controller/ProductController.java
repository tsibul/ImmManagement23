package com.immplan.injectionmanagement23.controller;

import com.immplan.injectionmanagement23.db.equipment.EquipmentTypeRepository;
import com.immplan.injectionmanagement23.db.product.product.Product;
import com.immplan.injectionmanagement23.db.product.product.ProductGroup;
import com.immplan.injectionmanagement23.db.product.product.repository.ProductGroupRepository;
import com.immplan.injectionmanagement23.db.product.product.repository.ProductRepository;
import com.immplan.injectionmanagement23.db.product.color.repository.ColorGroupRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/products")
    public String getProduct(Model model) {
        List<Product> products = productRepository.findProductByProductActiveOrderByProductCode(true);
        List<ProductGroup> productGroups = productGroupRepository.
                findProductGroupsByProductGroupActiveOrderByProductGroupName(true);
        populateModel(model);
        model.addAttribute("activePage", "products");
        model.addAttribute("products", products);
        model.addAttribute("productGroups", productGroups);
        return "products";
    }

    @PostMapping("/products/addproduct")
    public String addProduct(@ModelAttribute Product product) {
        productRepository.save(product);
        return "redirect:/products";
    }

    @GetMapping("/products/{id}/deleteproduct")
    public String deleteProduct(@PathVariable int id) {
        Product product = productRepository.findProductByProductId(id);
        product.setProductActive(false);
        productRepository.save(product);
        return "redirect:/products";
    }
}
