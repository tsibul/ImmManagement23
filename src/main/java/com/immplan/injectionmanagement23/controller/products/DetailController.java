package com.immplan.injectionmanagement23.controller.products;

import com.immplan.injectionmanagement23.controller.BaseController;
import com.immplan.injectionmanagement23.db.equipment.mold.MoldInsert;
import com.immplan.injectionmanagement23.db.equipment.mold.repository.MoldInsertRepository;
import com.immplan.injectionmanagement23.db.product.color.repository.ColorGroupRepository;
import com.immplan.injectionmanagement23.db.product.detail.Detail;
import com.immplan.injectionmanagement23.db.product.detail.repository.DetailRepository;
import com.immplan.injectionmanagement23.db.product.product.Product;
import com.immplan.injectionmanagement23.db.product.product.repository.ProductRepository;
import com.immplan.injectionmanagement23.db.rawmaterial.MaterialType;
import com.immplan.injectionmanagement23.db.rawmaterial.repository.MaterialTypeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class DetailController extends BaseController {

    private final DetailRepository detailRepository;
    private final ProductRepository productRepository;
    private final MaterialTypeRepository materialTypeRepository;
    private final MoldInsertRepository moldInsertRepository;


    public DetailController(ColorGroupRepository colorGroupRepository, ProductRepository productRepository,
                            MaterialTypeRepository materialTypeRepository, MoldInsertRepository moldInsertRepository,
                            DetailRepository detailRepository) {
        super(colorGroupRepository);

        this.detailRepository = detailRepository;
        this.productRepository = productRepository;
        this.moldInsertRepository = moldInsertRepository;
        this.materialTypeRepository = materialTypeRepository;
    }

    @GetMapping("/detail/{productsId}/{materialTypesId}")
    public String getProduct(Model model, @PathVariable Integer productsId, @PathVariable int materialTypesId) {
        Product urlProduct = productRepository.findProductByProductCode(productsId.toString());
        List<Detail> details;
        if (productsId == 0 && materialTypesId == 0) {
            details = detailRepository.findDetailByDetailActiveOrderByDetailCode(true);
        } else if (productsId != 0 && materialTypesId == 0) {
            details = detailRepository.
                    findDetailByDetailActiveAndDetailCodeOrderByIndexInProduct(true, urlProduct);

        } else if (productsId == 0) {
            details = detailRepository.
                    findDetailByDetailActiveAndMaterialTypeMaterialIdOrderByDetailCodeAscIndexInProduct(true, (long) materialTypesId);
        } else {

            details = detailRepository.
                    findDetailByDetailActiveAndMaterialTypeMaterialIdAndDetailCodeOrderByDetailCodeAscIndexInProduct(
                            true, (long) materialTypesId, urlProduct);
        }
        List<Product> products = productRepository.findProductByProductActiveOrderByProductCode(true);
        List<MaterialType> materialTypes = materialTypeRepository.findMaterialTypeByMaterialActiveOrderByMaterialName(true);
        List<MoldInsert> moldInserts = moldInsertRepository.findMoldInsertByEquipmentActiveOrderByEquipmentName(true);

        populateModel(model);
        model.addAttribute("activePage", "products");
        model.addAttribute("products", products);
        model.addAttribute("details", details);
        model.addAttribute("materialTypes", materialTypes);
        model.addAttribute("moldInserts", moldInserts);
        model.addAttribute("productsId", productsId);
        model.addAttribute("materialTypesId", materialTypesId);
        return "products/detail";
    }

    @PostMapping("/detail/add_detail")
    public String addProduct(@ModelAttribute Detail detail,
                             @RequestParam int productsId, @RequestParam int materialTypesId) {
        detailRepository.save(detail);
        return "redirect:/detail/" + productsId + "/" + materialTypesId;
    }

    @GetMapping("/detail/{id}/delete_detail")
    public String deleteProduct(@PathVariable int id,
                                @RequestParam int productsId, @RequestParam int materialTypesId) {
        Detail detail = detailRepository.getDetailByDetailId((long) id);
        detail.setDetailActive(false);
        detailRepository.save(detail);
        return "redirect:/detail/" + productsId + "/" + materialTypesId;
    }
}
