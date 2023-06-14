package com.immplan.injectionmanagement23.controller.equipment;

import com.immplan.injectionmanagement23.controller.BaseController;
import com.immplan.injectionmanagement23.db.equipment.Equipment;
import com.immplan.injectionmanagement23.db.equipment.EquipmentField;
import com.immplan.injectionmanagement23.db.equipment.EquipmentTypeRepository;
import com.immplan.injectionmanagement23.db.equipment.air.AirEquipmentRepository;
import com.immplan.injectionmanagement23.db.equipment.conveior.ConveyorRepository;
import com.immplan.injectionmanagement23.db.equipment.cooling.CoolingEquipmentRepository;
import com.immplan.injectionmanagement23.db.equipment.dozer.DozerRepository;
import com.immplan.injectionmanagement23.db.equipment.dryer.DryerRepository;
import com.immplan.injectionmanagement23.db.equipment.grinder.GrinderRepository;
import com.immplan.injectionmanagement23.db.equipment.injectionmoldingmachine.repository.InjectionMoldingMachineRepository;
import com.immplan.injectionmanagement23.db.equipment.injectionmoldingmachine.repository.SpacerPlateRepository;
import com.immplan.injectionmanagement23.db.equipment.materialloader.MaterialLoaderRepository;
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

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Supplier;

import static com.immplan.injectionmanagement23.db.equipment.EquipmentField.equipmentFields;
import static com.immplan.injectionmanagement23.db.equipment.EquipmentTypeRepository.equipmentTypeClassDict;
import static com.immplan.injectionmanagement23.db.equipment.EquipmentTypeRepository.equipmentTypeDict;


@Controller
public class EquipmentController extends BaseController {
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

    public EquipmentController(ColorGroupRepository colorGroupRepository, InjectionMoldingMachineRepository injectionMoldingMachineRepository,
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
        EquipmentTypeRepository equipmentTypeRepositoryClass = equipmentTypeInstance();
        Supplier<List<?>> query = equipmentTypeRepositoryClass.equipmentAllQuery().get(currentClass);
        List<?> equipment = query.get();
        List<Producer> producers = producerRepository.findProducerByProducerActiveAndProducerTypeOrderByProducerName(true, "Пресс-формы");
        populateModel(model);
        model.addAttribute("activePage", "equipment");
        model.addAttribute("equipmentList", equipment);
        model.addAttribute("producers", producers);
        model.addAttribute("fields", equipmentFields);
        model.addAttribute("title", title);
        model.addAttribute("equipmentType", equipmentType);
        return "equipment/equipment";
    }

    @PostMapping("/equipment/{equipmentType}/add_equipment")
    public String addMoldBase(HttpServletRequest request,
                              @PathVariable String equipmentType) throws InstantiationException, IllegalAccessException {
        Class currentClass = equipmentTypeClassDict().get(equipmentType);
        JpaRepository<Equipment, Long> equipmentRepository = equipmentRepository(equipmentType);
        Equipment equipment;
        if (request.getParameter("equipmentId").equals("")) {
            equipment = (Equipment) currentClass.newInstance();
        } else {
            Long equipmentId = Long.parseLong(request.getParameter("equipmentId"));
            Object equipmentInstance = equipmentRepository.findById(equipmentId).orElse(null);
            equipment = (Equipment) equipmentInstance;
        }
        //Словарь, где по имени поля класса хранится значение из post-запроса
        LinkedHashMap<String, Object> postRequest = postRequest(currentClass, request);
        //Поля родительского класса Equipment
        ArrayList<EquipmentField> equipmentFields = equipmentFields(Equipment.class);
        //Добавление полей дочернего класса
        equipmentFields.addAll(equipmentFields(currentClass));
        //Цикл по всем полям класса и запись значений из словаря postRequest
        for(EquipmentField equipmentField: equipmentFields){
            Field field = equipmentField.getFieldInstance();
            field.setAccessible(true);
            if(postRequest.keySet().contains(equipmentField.getEngName())){
                field.set(equipment, postRequest.get(equipmentField.getEngName()));
            }
        }
        equipmentRepository.save(equipment);
        return "redirect:/equipment/{equipmentType}";
    }


    @GetMapping("/equipment/{equipmentType}/{id}/delete_equipment")
    public String deleteEquipment(@PathVariable int id, @PathVariable String equipmentType) {
        JpaRepository<Equipment, Long> equipmentRepository = equipmentRepository(equipmentType);

        Object equipmentInstance = equipmentRepository.findById((long) id).orElse(null);
        Equipment equipment = (Equipment) equipmentInstance;

        equipment.setEquipmentActive(false);
        equipmentRepository.save(equipment);
        return "redirect:/equipment/{equipmentType}";
    }

    /**Словарь, где по имени поля класса хранится значение из post-запроса
     *
     * @param currentClass класс, для которого создается словарь
     * @param request     объект HttpServletRequest с данными post-запроса
     * @return словарь, где ключами являются имена полей класса, а значениями - соответствующие значения из post-запроса
     */
    private LinkedHashMap<String, Object> postRequest(Class currentClass, HttpServletRequest request) {
        //Подготовка данных из запроса
        LinkedHashMap<String, Object> postRequest = new LinkedHashMap<>();
        //Данные родительского класса
        postRequest.put("equipmentName", request.getParameter("equipmentName"));
        postRequest.put("inventoryCode", request.getParameter("invCode"));
        postRequest.put("equipmentCode", request.getParameter("equipmentCode"));
        postRequest.put("partNumber", request.getParameter("partNumber"));
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date yearProduction = dateformat.parse(request.getParameter("yearProd"));
            postRequest.put("yearProduction", yearProduction);
        } catch (ParseException ignored) {
        }
        try {
            Date receiveDate = dateformat.parse(request.getParameter("receive"));
            postRequest.put("receiveDate", receiveDate);
        } catch (ParseException ignored) {
        }
        if (request.getParameter("equipmentProducer") != null) {
            Producer producer = producerRepository.findProducerById(Long.parseLong(request.getParameter("equipmentProducer")));
            postRequest.put("equipmentProducer", producer);
        }
        //Данные дочерних классов
        ArrayList<EquipmentField> equipmentFields = equipmentFields(currentClass);
        for (EquipmentField field : equipmentFields) {
            Object value = null;
            String requestParamGet = request.getParameter(field.getEngName());
            switch (field.getFieldType()) {
                case "Long" -> value = Long.parseLong(requestParamGet);
                case "Integer" -> value = Integer.parseInt(requestParamGet);
                case "Double" -> value = Double.parseDouble(requestParamGet);
                case "Float" -> value = Float.parseFloat(requestParamGet);
                case "boolean" -> value = (requestParamGet.equals("true")) ? true :  false;
                case "String" -> value = (String) requestParamGet;
                default -> value = null;
            }
            if (value != null) postRequest.put(field.getEngName(), value);

        }
        return postRequest;
    }

    private JpaRepository<Equipment, Long> equipmentRepository(String equipmentType) {
        EquipmentTypeRepository equipmentTypeRepositoryInstance = equipmentTypeInstance();
        LinkedHashMap<String, JpaRepository<?, Long>> equipmentRepositoryDict = equipmentTypeRepositoryInstance.equipmentRepositoryDict();
        return (JpaRepository<Equipment, Long>) equipmentRepositoryDict.get(equipmentType);
    }

    private EquipmentTypeRepository equipmentTypeInstance(){
        return new EquipmentTypeRepository(injectionMoldingMachineRepository, spacerPlateRepository, moldBaseRepository,
                moldModifierRepository, moldInsertRepository, hydraulicCilinderRepository, coolingEquipmentRepository,
                airEquipmentRepository, thermostatRepository, thermoControllerRepository, grinderRepository,
                dryerRepository, materialLoaderRepository, dozerRepository, separatorRepository, conveyorRepository);
    }

}
