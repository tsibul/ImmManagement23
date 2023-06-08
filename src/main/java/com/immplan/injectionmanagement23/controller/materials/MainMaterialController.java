package com.immplan.injectionmanagement23.controller.materials;

import com.immplan.injectionmanagement23.controller.BaseController;
import com.immplan.injectionmanagement23.db.producer.Producer;
import com.immplan.injectionmanagement23.db.producer.repository.ProducerRepository;
import com.immplan.injectionmanagement23.db.product.color.Color;
import com.immplan.injectionmanagement23.db.product.color.repository.ColorGroupRepository;
import com.immplan.injectionmanagement23.db.product.color.repository.ColorRepository;
import com.immplan.injectionmanagement23.db.rawmaterial.MainMaterial;
import com.immplan.injectionmanagement23.db.rawmaterial.MaterialType;
import com.immplan.injectionmanagement23.db.rawmaterial.repository.MainMaterialRepository;
import com.immplan.injectionmanagement23.db.rawmaterial.repository.MaterialTypeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class MainMaterialController extends BaseController {

    private final MaterialTypeRepository materialTypeRepository;
    private final ColorRepository colorRepository;
    private final ProducerRepository producerRepository;
    private final MainMaterialRepository mainMaterialRepository;

    public MainMaterialController(ColorGroupRepository colorGroupRepository,
                                  MaterialTypeRepository materialTypeRepository, ColorRepository colorRepository,
                                  ProducerRepository producerRepository, MainMaterialRepository mainMaterialRepository) {
        super(colorGroupRepository);
        this.materialTypeRepository = materialTypeRepository;
        this.colorRepository = colorRepository;
        this.producerRepository = producerRepository;
        this.mainMaterialRepository = mainMaterialRepository;

    }

    @GetMapping("/main_material/{materialTypesId}/{producersId}")
    public String getProduct(Model model, @PathVariable int materialTypesId, @PathVariable int producersId) {
        List<MainMaterial> mainMaterials;
        if (materialTypesId == 0 && producersId == 0) {
            mainMaterials = mainMaterialRepository.findMainMaterialByMaterialActiveOrderByMaterialName(true);
        } else if (materialTypesId != 0 && producersId == 0) {
            mainMaterials = mainMaterialRepository.
                    findMainMaterialByMaterialActiveAndMaterialTypeMaterialIdOrderByMaterialName
                            (true, (long) materialTypesId);
        } else if (materialTypesId == 0) {
            mainMaterials = mainMaterialRepository.
                    findMainMaterialByMaterialActiveAndProducerIdOrderByMaterialName
                            (true, (long) producersId);
        } else {
            mainMaterials = mainMaterialRepository.
                    findMainMaterialByMaterialActiveAndProducerIdAndMaterialTypeMaterialIdOrderByMaterialName
                            (true, (long) producersId, (long) materialTypesId);
        }
        List<MaterialType> materialTypes = materialTypeRepository.
                findMaterialTypeByMaterialActiveOrderByMaterialName(true);
        List<Color> colors = colorRepository.findColorByColorActiveOrderByColorGroupAscColorCode(true);
        List<Producer> producers = producerRepository.findProducerByProducerActiveAndProducerTypeOrderByProducerName(true, "Сырье");

        populateModel(model);
        model.addAttribute("activePage", "materials");
        model.addAttribute("mainMaterials", mainMaterials);
        model.addAttribute("materialTypes", materialTypes);
        model.addAttribute("colors", colors);
        model.addAttribute("producers", producers);

        model.addAttribute("materialTypesId", materialTypesId);
        model.addAttribute("producersId", producersId);
        return "materials/main_material";
    }

    @PostMapping("/main_material/add_main_material")
    public String addProduct(@ModelAttribute MainMaterial mainMaterial,
                             @RequestParam int materialTypesId, @RequestParam int producersId) {
        mainMaterialRepository.save(mainMaterial);
        return "redirect:/main_material/" + materialTypesId + "/" + producersId;
    }

    @GetMapping("/main_material/{id}/delete_main_material")
    public String deleteProduct(@PathVariable int id,
                                @RequestParam int materialTypesId, @RequestParam int producersId) {
        MainMaterial mainMaterial = mainMaterialRepository.findMainMaterialByMaterialId((long) id);
        mainMaterial.setMaterialActive(false);
        mainMaterialRepository.save(mainMaterial);
        return "redirect:/main_material/" + materialTypesId + "/" + producersId;
    }
}
