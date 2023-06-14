package com.immplan.injectionmanagement23.db.equipment;

import com.immplan.injectionmanagement23.db.equipment.air.AirEquipment;
import com.immplan.injectionmanagement23.db.equipment.air.AirEquipmentRepository;
import com.immplan.injectionmanagement23.db.equipment.conveior.Conveyor;
import com.immplan.injectionmanagement23.db.equipment.conveior.ConveyorRepository;
import com.immplan.injectionmanagement23.db.equipment.cooling.CoolingEquipment;
import com.immplan.injectionmanagement23.db.equipment.cooling.CoolingEquipmentRepository;
import com.immplan.injectionmanagement23.db.equipment.dozer.Dozer;
import com.immplan.injectionmanagement23.db.equipment.dozer.DozerRepository;
import com.immplan.injectionmanagement23.db.equipment.dryer.Dryer;
import com.immplan.injectionmanagement23.db.equipment.dryer.DryerRepository;
import com.immplan.injectionmanagement23.db.equipment.grinder.Grinder;
import com.immplan.injectionmanagement23.db.equipment.grinder.GrinderRepository;
import com.immplan.injectionmanagement23.db.equipment.injectionmoldingmachine.InjectionMoldingMachine;
import com.immplan.injectionmanagement23.db.equipment.injectionmoldingmachine.SpacerPlate;
import com.immplan.injectionmanagement23.db.equipment.injectionmoldingmachine.repository.InjectionMoldingMachineRepository;
import com.immplan.injectionmanagement23.db.equipment.injectionmoldingmachine.repository.SpacerPlateRepository;
import com.immplan.injectionmanagement23.db.equipment.materialloader.MaterialLoader;
import com.immplan.injectionmanagement23.db.equipment.materialloader.MaterialLoaderRepository;
import com.immplan.injectionmanagement23.db.equipment.mold.HydraulicCylinder;
import com.immplan.injectionmanagement23.db.equipment.mold.MoldBase;
import com.immplan.injectionmanagement23.db.equipment.mold.MoldInsert;
import com.immplan.injectionmanagement23.db.equipment.mold.MoldModifier;
import com.immplan.injectionmanagement23.db.equipment.mold.repository.HydraulicCilinderRepository;
import com.immplan.injectionmanagement23.db.equipment.mold.repository.MoldBaseRepository;
import com.immplan.injectionmanagement23.db.equipment.mold.repository.MoldInsertRepository;
import com.immplan.injectionmanagement23.db.equipment.mold.repository.MoldModifierRepository;
import com.immplan.injectionmanagement23.db.equipment.materialseparator.MaterialSeparator;
import com.immplan.injectionmanagement23.db.equipment.materialseparator.MaterialSeparatorRepository;
import com.immplan.injectionmanagement23.db.equipment.thermocontroller.ThermoController;
import com.immplan.injectionmanagement23.db.equipment.thermocontroller.ThermoControllerRepository;
import com.immplan.injectionmanagement23.db.equipment.thermostat.Thermostat;
import com.immplan.injectionmanagement23.db.equipment.thermostat.ThermostatRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Supplier;

public class EquipmentTypeRepository {

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

    public EquipmentTypeRepository(InjectionMoldingMachineRepository injectionMoldingMachineRepository,
                                   SpacerPlateRepository spacerPlateRepository,
                                   MoldBaseRepository moldBaseRepository, MoldModifierRepository moldModifierRepository,
                                   MoldInsertRepository moldInsertRepository,
                                   HydraulicCilinderRepository hydraulicCilinderRepository,
                                   CoolingEquipmentRepository coolingEquipmentRepository,
                                   AirEquipmentRepository airEquipmentRepository, ThermostatRepository thermostatRepository,
                                   ThermoControllerRepository thermoControllerRepository, GrinderRepository grinderRepository,
                                   DryerRepository dryerRepository, MaterialLoaderRepository materialLoaderRepository,
                                   DozerRepository dozerRepository, MaterialSeparatorRepository separatorRepository,
                                   ConveyorRepository conveyorRepository) {
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

    public LinkedHashMap<Class<?>, Supplier<List<?>>> equipmentAllQuery() {
        LinkedHashMap<Class<?>, Supplier<List<?>>> queryDict = new LinkedHashMap<>();
        queryDict.put(InjectionMoldingMachine.class, () -> injectionMoldingMachineRepository.
                findInjectionMoldingMachineByEquipmentActiveOrderByInternalNo(true));
        queryDict.put(SpacerPlate.class, () -> spacerPlateRepository.
                findSpacerPlateByEquipmentActiveOrderByEquipmentCode(true));
        queryDict.put(MoldBase.class, () -> moldBaseRepository.
                findMoldBaseByEquipmentActiveOrderByInventoryCode(true));
        queryDict.put(MoldModifier.class, () -> moldModifierRepository.
                findMoldModifierByEquipmentActiveOrderByInventoryCode(true));
        queryDict.put(MoldInsert.class, () -> moldInsertRepository.
                findMoldInsertByEquipmentActiveOrderByEquipmentName(true));
        queryDict.put(HydraulicCylinder.class, () -> hydraulicCilinderRepository.
                findHydraulicCylinderByEquipmentActiveOrderByEquipmentCode(true));
        queryDict.put(CoolingEquipment.class, () -> coolingEquipmentRepository.
                findCoolingEquipmentByEquipmentActiveOrderByEquipmentName(true));
        queryDict.put(AirEquipment.class, () -> airEquipmentRepository.
                findAirEquipmentByEquipmentActiveOrderByEquipmentName(true));
        queryDict.put(Thermostat.class, () -> thermostatRepository.
                findThermostatByEquipmentActiveOrderByEquipmentCode(true));
        queryDict.put(ThermoController.class, () -> thermoControllerRepository.
                findThermoControllerByEquipmentActiveOrderByEquipmentCode(true));
        queryDict.put(Grinder.class, () -> grinderRepository.
                findGrinderByEquipmentActiveOrderByInventoryCode(true));
        queryDict.put(Dryer.class, () -> dryerRepository.
                findDryerByEquipmentActiveOrderByEquipmentCode(true));
        queryDict.put(MaterialLoader.class, () -> materialLoaderRepository.
                findMaterialLoaderByEquipmentActiveOrderByEquipmentCode(true));
        queryDict.put(Dozer.class, () -> dozerRepository.
                findDozerByEquipmentActiveOrderByEquipmentCode(true));
        queryDict.put(MaterialSeparator.class, () -> separatorRepository.
                findSeparatorByEquipmentActiveOrderByEquipmentCode(true));
        queryDict.put(Conveyor.class, () -> conveyorRepository.
                findConveyorByEquipmentActiveOrderByEquipmentCode(true));
        return queryDict;
    }
    public static LinkedHashMap<String, String> equipmentTypeDict() {
        LinkedHashMap<String, String> equipmentTypeDict = new LinkedHashMap<>();
        equipmentTypeDict.put("01.01", "Термопластавтомат");
        equipmentTypeDict.put("01.02", "Крепежная плита");
        equipmentTypeDict.put("02.01", "Пресс-форма");
        equipmentTypeDict.put("02.02", "Модификатор к пресс-форме");
        equipmentTypeDict.put("02.03", "Вставка в пресс-форму");
        equipmentTypeDict.put("02.04", "Гидроцилиндр");
        equipmentTypeDict.put("03.01", "Охлаждение");
        equipmentTypeDict.put("03.02", "Воздух");
        equipmentTypeDict.put("03.03", "Термостаты");
        equipmentTypeDict.put("03.04", "Термоконтроллеры");
        equipmentTypeDict.put("03.05", "Дробилки");
        equipmentTypeDict.put("03.06", "Сушилки");
        equipmentTypeDict.put("03.07", "Загрузчики");
        equipmentTypeDict.put("03.08", "Дозаторы");
        equipmentTypeDict.put("03.09", "Сепараторы");
        equipmentTypeDict.put("03.10", "Транспортеры");
        return equipmentTypeDict;
    }
    public static LinkedHashMap<String, Class> equipmentTypeClassDict() {
        LinkedHashMap<String, Class> equipmentTypeDict = new LinkedHashMap<>();
        equipmentTypeDict.put("01.01", InjectionMoldingMachine.class);
        equipmentTypeDict.put("01.02", SpacerPlate.class);
        equipmentTypeDict.put("02.01", MoldBase.class);
        equipmentTypeDict.put("02.02", MoldModifier.class);
        equipmentTypeDict.put("02.03", MoldInsert.class);
        equipmentTypeDict.put("02.04", HydraulicCylinder.class);
        equipmentTypeDict.put("03.01", CoolingEquipment.class);
        equipmentTypeDict.put("03.02", AirEquipment.class);
        equipmentTypeDict.put("03.03", Thermostat.class);
        equipmentTypeDict.put("03.04", ThermoController.class);
        equipmentTypeDict.put("03.05", Grinder.class);
        equipmentTypeDict.put("03.06", Dryer.class);
        equipmentTypeDict.put("03.07", MaterialLoader.class);
        equipmentTypeDict.put("03.08", Dozer.class);
        equipmentTypeDict.put("03.09", MaterialSeparator.class);
        equipmentTypeDict.put("03.10", Conveyor.class);
        return equipmentTypeDict;
    }
    public LinkedHashMap<String, JpaRepository<?, Long>> equipmentRepositoryDict() {
        LinkedHashMap<String, JpaRepository<?, Long>> equipmentRepositoryDict = new LinkedHashMap<>();
        equipmentRepositoryDict.put("01.01", injectionMoldingMachineRepository);
        equipmentRepositoryDict.put("01.02", spacerPlateRepository);
        equipmentRepositoryDict.put("02.01", moldBaseRepository);
        equipmentRepositoryDict.put("02.02", moldModifierRepository);
        equipmentRepositoryDict.put("02.03", moldInsertRepository);
        equipmentRepositoryDict.put("02.04", hydraulicCilinderRepository);
        equipmentRepositoryDict.put("03.01", coolingEquipmentRepository);
        equipmentRepositoryDict.put("03.02", airEquipmentRepository);
        equipmentRepositoryDict.put("03.03", thermostatRepository);
        equipmentRepositoryDict.put("03.04", thermoControllerRepository);
        equipmentRepositoryDict.put("03.05", grinderRepository);
        equipmentRepositoryDict.put("03.06", dryerRepository);
        equipmentRepositoryDict.put("03.07", materialLoaderRepository);
        equipmentRepositoryDict.put("03.08", dozerRepository);
        equipmentRepositoryDict.put("03.09", separatorRepository);
        equipmentRepositoryDict.put("03.10", conveyorRepository);
        return equipmentRepositoryDict;
    }


}
