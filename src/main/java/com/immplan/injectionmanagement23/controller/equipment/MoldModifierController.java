package com.immplan.injectionmanagement23.controller.equipment;

import com.immplan.injectionmanagement23.controller.BaseController;
import com.immplan.injectionmanagement23.db.equipment.Equipment;
import com.immplan.injectionmanagement23.db.equipment.EquipmentField;
import com.immplan.injectionmanagement23.db.equipment.EquipmentType;
import com.immplan.injectionmanagement23.db.equipment.air.AirEquipmentRepository;
import com.immplan.injectionmanagement23.db.equipment.conveior.ConveyorRepository;
import com.immplan.injectionmanagement23.db.equipment.cooling.CoolingEquipmentRepository;
import com.immplan.injectionmanagement23.db.equipment.dozer.DozerRepository;
import com.immplan.injectionmanagement23.db.equipment.dryer.DryerRepository;
import com.immplan.injectionmanagement23.db.equipment.grinder.GrinderRepository;
import com.immplan.injectionmanagement23.db.equipment.injectionmoldingmachine.repository.InjectionMoldingMachineRepository;
import com.immplan.injectionmanagement23.db.equipment.injectionmoldingmachine.repository.SpacerPlateRepository;
import com.immplan.injectionmanagement23.db.equipment.materialloader.MaterialLoaderRepository;
import com.immplan.injectionmanagement23.db.equipment.mold.MoldModifier;
import com.immplan.injectionmanagement23.db.equipment.mold.repository.HydraulicCilinderRepository;
import com.immplan.injectionmanagement23.db.equipment.mold.repository.MoldBaseRepository;
import com.immplan.injectionmanagement23.db.equipment.mold.repository.MoldInsertRepository;
import com.immplan.injectionmanagement23.db.equipment.mold.repository.MoldModifierRepository;
import com.immplan.injectionmanagement23.db.equipment.materialseparator.MaterialSeparatorRepository;
import com.immplan.injectionmanagement23.db.equipment.thermocontroller.ThermoControllerRepository;
import com.immplan.injectionmanagement23.db.equipment.thermostat.ThermostatRepository;
import com.immplan.injectionmanagement23.db.producer.Producer;
import com.immplan.injectionmanagement23.db.producer.repository.ProducerRepository;
import com.immplan.injectionmanagement23.db.product.color.repository.ColorGroupRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Supplier;

import static com.immplan.injectionmanagement23.db.equipment.EquipmentField.equipmentFields;
import static com.immplan.injectionmanagement23.db.equipment.EquipmentType.equipmentTypeClassDict;
import static com.immplan.injectionmanagement23.db.equipment.EquipmentType.equipmentTypeDict;


@Controller
public class MoldModifierController extends BaseController {
    private final InjectionMoldingMachineRepository injectionMoldingMachineRepository;
    private final SpacerPlateRepository spacerPlateRepository;
    private final MoldBaseRepository moldBaseRepository;
    private final MoldModifierRepository moldModifierRepository;
    private final MoldInsertRepository moldInsertRepository;
    private final HydraulicCilinderRepository hydraulicCilinderRepository;
    private final CoolingEquipmentRepository coolingEquipmentRepository;
    private final AirEquipmentRepository airEquipmentRepository;
    private final ThermostatRepository thermostatRepository;
    private final ThermoControllerRepository thermoControllerRepository;
    private final GrinderRepository grinderRepository;
    private final DryerRepository dryerRepository;
    private final MaterialLoaderRepository materialLoaderRepository;
    private final DozerRepository dozerRepository;
    private final MaterialSeparatorRepository separatorRepository;
    private final ConveyorRepository conveyorRepository;

    private final ProducerRepository producerRepository;

    public MoldModifierController(ColorGroupRepository colorGroupRepository, InjectionMoldingMachineRepository injectionMoldingMachineRepository,
                                  SpacerPlateRepository spacerPlateRepository,
                                  MoldBaseRepository moldBaseRepository, MoldModifierRepository moldModifierRepository,
                                  MoldInsertRepository moldInsertRepository,
                                  HydraulicCilinderRepository hydraulicCilinderRepository,
                                  CoolingEquipmentRepository coolingEquipmentRepository,
                                  AirEquipmentRepository airEquipmentRepository, ThermostatRepository thermostatRepository,
                                  ThermoControllerRepository thermoControllerRepository, GrinderRepository grinderRepository,
                                  DryerRepository dryerRepository, MaterialLoaderRepository materialLoaderRepository,
                                  DozerRepository dozerRepository, MaterialSeparatorRepository separatorRepository,
                                  ConveyorRepository conveyorRepository,
                                  ProducerRepository producerRepository) {
        super(colorGroupRepository);
        this.producerRepository = producerRepository;
        this.injectionMoldingMachineRepository = injectionMoldingMachineRepository;
        this.spacerPlateRepository = spacerPlateRepository;
        this.moldBaseRepository = moldBaseRepository;
        this.moldModifierRepository = moldModifierRepository;
        this.moldInsertRepository = moldInsertRepository;
        this.hydraulicCilinderRepository = hydraulicCilinderRepository;
        this.coolingEquipmentRepository = coolingEquipmentRepository;
        this.airEquipmentRepository = airEquipmentRepository;
        this.thermostatRepository = thermostatRepository;
        this.thermoControllerRepository = thermoControllerRepository;
        this.grinderRepository = grinderRepository;
        this.dryerRepository = dryerRepository;
        this.materialLoaderRepository = materialLoaderRepository;
        this.dozerRepository = dozerRepository;
        this.separatorRepository = separatorRepository;
        this.conveyorRepository = conveyorRepository;
    }

    @GetMapping("/equipment/{equipmentType}")
    public String getEquipment(Model model, @PathVariable String equipmentType) {
        Class currentClass = equipmentTypeClassDict().get(equipmentType);
        String title = equipmentTypeDict().get(equipmentType);
        ArrayList<EquipmentField> equipmentFields = equipmentFields(currentClass);
        EquipmentType equipmentTypeClass = new EquipmentType(injectionMoldingMachineRepository, spacerPlateRepository, moldBaseRepository,
                moldModifierRepository, moldInsertRepository, hydraulicCilinderRepository, coolingEquipmentRepository,
                airEquipmentRepository, thermostatRepository, thermoControllerRepository, grinderRepository,
                dryerRepository, materialLoaderRepository, dozerRepository, separatorRepository, conveyorRepository);
        Supplier<List<?>> query = equipmentTypeClass.equipmentAllQuery().get(currentClass);
        List<?> equipment = query.get();
        List<Producer> producers = producerRepository.findProducerByProducerActiveAndProducerTypeOrderByProducerName(true, "Пресс-формы");
        populateModel(model);
        model.addAttribute("activePage", "equipment");
        model.addAttribute("moldModifiers", equipment);
        model.addAttribute("producers", producers);
        model.addAttribute("fields", equipmentFields);
        model.addAttribute("title", title);
        return "equipment/mold_modifier";
    }

    @PostMapping("/equipment/{equipmentType}/add_mold_modifier")
    public String addMoldBase(@ModelAttribute Equipment equipment,
                              @RequestParam String yearProd, @RequestParam String receive,
                              @RequestParam String invCode, HttpServletRequest request) {
        equipment.setInventoryCode(invCode);
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date yearProduction = dateformat.parse(yearProd);
            equipment.setYearProduction(yearProduction);
        } catch (ParseException ignored) {
        }
        try {
            Date receiveDate = dateformat.parse(receive);
            equipment.setReceiveDate(receiveDate);
        } catch (ParseException ignored) {
        }
        moldModifierRepository.save((MoldModifier) equipment);
        return "redirect:/equipment/{equipmentType}";
    }


    @GetMapping("/equipment/{equipmentType}/{id}/delete_mold_modifier")
    public String deleteEquipment(@PathVariable int id, @PathVariable String equipmentType) {
        EquipmentType equipmentTypeInstance = new EquipmentType(injectionMoldingMachineRepository, spacerPlateRepository, moldBaseRepository,
                moldModifierRepository, moldInsertRepository, hydraulicCilinderRepository, coolingEquipmentRepository,
                airEquipmentRepository, thermostatRepository, thermoControllerRepository, grinderRepository,
                dryerRepository, materialLoaderRepository, dozerRepository, separatorRepository, conveyorRepository);
        LinkedHashMap<String, JpaRepository<?, Long>> equipmentRepositoryDict = equipmentTypeInstance.equipmentRepositoryDict();
        JpaRepository<Equipment, Long> equipmentRepository = (JpaRepository<Equipment, Long>) equipmentRepositoryDict.get(equipmentType);

        Object equipmentInstance = equipmentRepository.findById((long) id).orElse(null);
        Equipment equipment = (Equipment) equipmentInstance;
        equipment.setEquipmentActive(false);
        equipmentRepository.save(equipment);

        return "redirect:/equipment/{equipmentType}";
    }


}
