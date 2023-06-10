package com.immplan.injectionmanagement23.controller.equipment;

import com.immplan.injectionmanagement23.controller.BaseController;
import com.immplan.injectionmanagement23.db.equipment.mold.MoldInsert;
import com.immplan.injectionmanagement23.db.equipment.mold.MoldModifier;
import com.immplan.injectionmanagement23.db.equipment.mold.repository.MoldInsertRepository;
import com.immplan.injectionmanagement23.db.equipment.mold.repository.MoldModifierRepository;
import com.immplan.injectionmanagement23.db.producer.Producer;
import com.immplan.injectionmanagement23.db.producer.repository.ProducerRepository;
import com.immplan.injectionmanagement23.db.product.color.repository.ColorGroupRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
public class MoldInsertController extends BaseController {
    private final MoldInsertRepository moldInsertRepository;
    private final ProducerRepository producerRepository;

    public MoldInsertController(ColorGroupRepository colorGroupRepository,
                                MoldInsertRepository moldInsertRepository, ProducerRepository producerRepository) {
        super(colorGroupRepository);
        this.producerRepository = producerRepository;
        this.moldInsertRepository = moldInsertRepository;
    }

    @GetMapping("/equipment/02.03")
    public String getMoldBase(Model model) {
        List<MoldInsert> moldInserts = moldInsertRepository.findMoldInsertByEquipmentActiveOrderByEquipmentName(true);
        List<Producer> producers = producerRepository.findProducerByProducerActiveAndProducerTypeOrderByProducerName(true, "Пресс-формы");
        populateModel(model);
        model.addAttribute("activePage", "equipment");
        model.addAttribute("moldInserts", moldInserts);
        model.addAttribute("producers", producers);
        return "equipment/mold_insert";
    }

    @PostMapping("/equipment/02.03/add_mold_insert")
    public String addMoldBase(@ModelAttribute MoldInsert moldInsert,
                              @RequestParam String yearProd, @RequestParam String receive, @RequestParam String invCode) {
        moldInsert.setInventoryCode(invCode);
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date yearProduction = dateformat.parse(yearProd);
            moldInsert.setYearProduction(yearProduction);
        } catch (ParseException ignored) {
        }
        try {
            Date receiveDate = dateformat.parse(receive);
            moldInsert.setReceiveDate(receiveDate);
        } catch (ParseException ignored) {
        }
        moldInsertRepository.save(moldInsert);
        return "redirect:/equipment/02.03";
    }

    @GetMapping("/equipment/02.03/{id}/delete_mold_insert")
    public String deleteColorGroup(@PathVariable int id) {
        MoldInsert moldInsert = moldInsertRepository.findMoldInsertByEquipmentIdOrderByEquipmentName((long) id);
        moldInsert.setEquipmentActive(false);
        moldInsertRepository.save(moldInsert);
        return "redirect:/equipment/02.02";
    }
}
