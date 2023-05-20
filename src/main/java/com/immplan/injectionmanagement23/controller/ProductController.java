package com.immplan.injectionmanagement23.controller;

import com.immplan.injectionmanagement23.db.equipment.EquipmentTypeRepository;
import com.immplan.injectionmanagement23.db.product.Product;
import com.immplan.injectionmanagement23.db.product.ProductRepository;
import com.immplan.injectionmanagement23.db.product.color.repository.ColorGroupRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class ProductController extends BaseController {

    private final ProductRepository productRepository;

    public ProductController(EquipmentTypeRepository equipmentTypeRepository,
                             ColorGroupRepository colorGroupRepository, ProductRepository productRepository) {
        super(equipmentTypeRepository, colorGroupRepository);

        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public String getProduct(Model model) {
        List<Product> products = productRepository.findProductByProductActiveOrderByProductCode(true);
        populateModel(model);
        model.addAttribute("activePage", "products");
        model.addAttribute("products", products);
        return "products";
    }

    @PostMapping("/products/addproduct")
    public String addProduct(@ModelAttribute Product product) {
        productRepository.save(product);
        return "redirect:/products";
    }

    @GetMapping("/products/{id}/deleteproduct")
    public String deleteProduct( @PathVariable int id) {
        Product product = productRepository.findProductByProductId(id);
        product.setProductActive(false);
        productRepository.save(product);
        return "redirect:/products";
    }
}
