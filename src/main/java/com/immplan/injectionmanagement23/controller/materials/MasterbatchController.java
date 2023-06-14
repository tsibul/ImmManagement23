package com.immplan.injectionmanagement23.controller.materials;

import com.immplan.injectionmanagement23.controller.BaseController;
import com.immplan.injectionmanagement23.db.producer.Producer;
import com.immplan.injectionmanagement23.db.producer.repository.ProducerRepository;
import com.immplan.injectionmanagement23.db.product.color.repository.ColorGroupRepository;
import com.immplan.injectionmanagement23.db.rawmaterial.MasterBatch;
import com.immplan.injectionmanagement23.db.rawmaterial.repository.MasterBatchRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class MasterbatchController extends BaseController {

    private final ProducerRepository producerRepository;
    private final MasterBatchRepository masterBatchRepository;

    public MasterbatchController(ColorGroupRepository colorGroupRepository, ProducerRepository producerRepository,
                                 MasterBatchRepository masterBatchRepository) {
        super(colorGroupRepository);
        this.masterBatchRepository = masterBatchRepository;
        this.producerRepository = producerRepository;
    }

    @GetMapping("/masterbatch/{id}")
    public String getColor(@PathVariable("id") int id, Model model) {
        Producer producer;
        List<MasterBatch> masterBatches;
        List<Producer> producers = producerRepository.
                findProducerByProducerActiveAndProducerTypeOrderByProducerName(true, "Суперконцентраты");
        if (id != 0) {
            producer = producerRepository.findProducerById((long) id);
            masterBatches = masterBatchRepository.
                    getMasterBatchByMaterialActiveAndProducerOrderByMaterialName(true, producer);
            model.addAttribute("producersId", producer.getId());
        } else {
            masterBatches = masterBatchRepository.getMasterBatchByMaterialActiveOrderByMaterialName(true);
            model.addAttribute("producersId", 0);
        }
        populateModel(model);
        model.addAttribute("activePage", "dicts");
        model.addAttribute("masterBatches", masterBatches);
        model.addAttribute("producers", producers);
        return "materials/masterbatch";
    }

    @PostMapping("/masterbatch/{id}/add_masterbatch")
    public String addColor(@PathVariable("id") int id, @ModelAttribute MasterBatch masterBatch) {
        masterBatchRepository.save(masterBatch);
        return "redirect:/masterbatch/" + id;
    }

    @GetMapping("/masterbatch/{producerId}/{id}/delete_masterbatch")
    public String deleteColor(@PathVariable int producerId, @PathVariable int id) {
        MasterBatch masterBatch = masterBatchRepository.findMasterBatchByMaterialId((long) id);
        masterBatch.setMaterialActive(false);
        masterBatchRepository.save(masterBatch);
        return "redirect:/masterbatch/" + id;
    }
}
