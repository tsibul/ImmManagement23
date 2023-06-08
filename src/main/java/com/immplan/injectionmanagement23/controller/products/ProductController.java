package com.immplan.injectionmanagement23.controller.products;

import com.immplan.injectionmanagement23.controller.BaseController;
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

    public ProductController(ColorGroupRepository colorGroupRepository, ProductRepository productRepository,
                             ProductGroupRepository productGroupRepository) {
        super(colorGroupRepository);

        this.productRepository = productRepository;
        this.productGroupRepository = productGroupRepository;
    }

    @GetMapping("/products/{productGroupId}")
    public String getProduct(Model model, @PathVariable int productGroupId) {
        List<Product> products;
        if (productGroupId == 0) {
            products = productRepository.findProductByProductActiveOrderByProductCode(true);
        } else {
            products = productRepository.
                    findProductByProductActiveAndProductGroupProductGroupIdOrderByProductCode
                            (true, (long) productGroupId);
        }
        List<ProductGroup> productGroups = productGroupRepository.
                findProductGroupsByProductGroupActiveOrderByProductGroupName(true);

        populateModel(model);
        model.addAttribute("activePage", "products");
        model.addAttribute("products", products);
        model.addAttribute("productGroups", productGroups);
        model.addAttribute("productGroupsId", productGroupId);
        return "products/products";
    }

    @PostMapping("/products/addproduct")
    public String addProduct(@ModelAttribute Product product, @RequestParam int productGroupsId) {
        productRepository.save(product);
        return "redirect:/products/" + productGroupsId;
    }

    @GetMapping("/products/{id}/deleteproduct")
    public String deleteProduct(@PathVariable int id, @RequestParam int productGroupsId) {
        Product product = productRepository.findProductByProductId(id);
        product.setProductActive(false);
        productRepository.save(product);
        return "redirect:/products/" + productGroupsId;
    }
}
