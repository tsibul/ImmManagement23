package com.immplan.injectionmanagement23.controller.products;

import com.immplan.injectionmanagement23.controller.BaseController;
import com.immplan.injectionmanagement23.db.equipment.EquipmentTypeRepository;
import com.immplan.injectionmanagement23.db.product.color.repository.ColorGroupRepository;
import com.immplan.injectionmanagement23.db.product.detail.Detail;
import com.immplan.injectionmanagement23.db.product.detail.DetailToProduct;
import com.immplan.injectionmanagement23.db.product.detail.repository.DetailRepository;
import com.immplan.injectionmanagement23.db.product.detail.repository.DetailToProductRepository;
import com.immplan.injectionmanagement23.db.product.product.Product;
import com.immplan.injectionmanagement23.db.product.product.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class DetailToProductController extends BaseController {

    private final ProductRepository productRepository;
    private final DetailRepository detailRepository;
    private final DetailToProductRepository detailToProductRepository;

    public DetailToProductController(EquipmentTypeRepository equipmentTypeRepository,
                                     ColorGroupRepository colorGroupRepository, ProductRepository productRepository,
                                     DetailRepository detailRepository, DetailToProductRepository detailToProductRepository) {
        super(equipmentTypeRepository, colorGroupRepository);

        this.productRepository = productRepository;
        this.detailRepository = detailRepository;
        this.detailToProductRepository = detailToProductRepository;
    }

    @GetMapping("/detail_to_product/{productsId}")
    public String getProduct(Model model, @PathVariable int productsId) {
        List<DetailToProduct> detailToProducts;
        if (productsId == 0) {
            detailToProducts = detailToProductRepository.findDetailToProductsByDetailToProductActiveOrderByProduct(true);
        } else {
            detailToProducts = detailToProductRepository.
                    findDetailToProductsByDetailToProductActiveAndProductProductIdOrderByProductProductName(true, (long) productsId);
        }
        List<Product> products = productRepository.findProductByProductActiveOrderByProductCode(true);
        List<Detail> details = detailRepository.findDetailByDetailActiveOrderByDetailCode(true);

        populateModel(model);
        model.addAttribute("activePage", "products");
        model.addAttribute("products", products);
        model.addAttribute("productsId", productsId);
        model.addAttribute("details", details);
        model.addAttribute("detailToProducts", detailToProducts);
        return "products/detail_to_product";
    }

    @PostMapping("/detail_to_product/add_detail_to_product")
    public String addProduct(@ModelAttribute DetailToProduct detailToProduct, @RequestParam int productsId) {
        detailToProductRepository.save(detailToProduct);
        return "redirect:/detail_to_product/" + productsId;
    }

    @GetMapping("/detail_to_product/{id}/delete_detail_to_product")
    public String deleteProduct(@PathVariable int id, @RequestParam int productsId) {
        DetailToProduct detailToProduct = detailToProductRepository.findDetailToProductByDetailToProductId((long) id);
        detailToProduct.setDetailToProductActive(false);
        detailToProductRepository.save(detailToProduct);
        return "redirect:/detail_to_product/" + productsId;
    }
}
