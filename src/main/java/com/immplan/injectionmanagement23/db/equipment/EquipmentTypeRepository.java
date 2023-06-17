package com.immplan.injectionmanagement23.db.equipment;

import com.immplan.injectionmanagement23.db.common.CommonEquipmentRepository;
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

import java.util.*;
import java.util.function.Supplier;

import static com.immplan.injectionmanagement23.db.equipment.EquipmentType.equipmentTypeArrayList;

public class EquipmentTypeRepository  implements CommonEquipmentRepository<Equipment> {

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

    public EquipmentTypeRepository(){
        this.injectionMoldingMachineRepository = null;
        this.spacerPlateRepository = null;
        this.moldBaseRepository = null;
        this.moldModifierRepository = null;
        this.moldInsertRepository = null;
        this.hydraulicCilinderRepository = null;
        this.coolingEquipmentRepository = null;
        this.airEquipmentRepository = null;
        this.thermostatRepository = null;
        this.thermoControllerRepository = null;
        this.grinderRepository = null;
        this.dryerRepository = null;
        this.materialLoaderRepository = null;
        this.dozerRepository = null;
        this.separatorRepository = null;
        this.conveyorRepository = null;

    }

    public InjectionMoldingMachineRepository getInjectionMoldingMachineRepository() {
        return injectionMoldingMachineRepository;
    }

    public SpacerPlateRepository getSpacerPlateRepository() {
        return spacerPlateRepository;
    }

    public MoldBaseRepository getMoldBaseRepository() {
        return moldBaseRepository;
    }

    public MoldModifierRepository getMoldModifierRepository() {
        return moldModifierRepository;
    }

    public MoldInsertRepository getMoldInsertRepository() {
        return moldInsertRepository;
    }

    public HydraulicCilinderRepository getHydraulicCilinderRepository() {
        return hydraulicCilinderRepository;
    }

    public CoolingEquipmentRepository getCoolingEquipmentRepository() {
        return coolingEquipmentRepository;
    }

    public AirEquipmentRepository getAirEquipmentRepository() {
        return airEquipmentRepository;
    }

    public ThermostatRepository getThermostatRepository() {
        return thermostatRepository;
    }

    public ThermoControllerRepository getThermoControllerRepository() {
        return thermoControllerRepository;
    }

    public GrinderRepository getGrinderRepository() {
        return grinderRepository;
    }

    public DryerRepository getDryerRepository() {
        return dryerRepository;
    }

    public MaterialLoaderRepository getMaterialLoaderRepository() {
        return materialLoaderRepository;
    }

    public DozerRepository getDozerRepository() {
        return dozerRepository;
    }

    public MaterialSeparatorRepository getSeparatorRepository() {
        return separatorRepository;
    }

    public ConveyorRepository getConveyorRepository() {
        return conveyorRepository;
    }

     public LinkedHashMap<Class<?>, Supplier<List<?>>> equipmentAllQuery() {
        LinkedHashMap<Class<?>, Supplier<List<?>>> queryDict = new LinkedHashMap<>();
         for (EquipmentType equipmentType: equipmentTypeArrayList()
              ) {
             queryDict.put(equipmentType.getEquipmentClass(), () -> equipmentRepositoryDict().
                     get(equipmentType.getEquipmentTypeId()).findEquipmentByActiveOrderByName(true));
         }
        return queryDict;
    }
    public static LinkedHashMap<String, EquipmentType> equipmentTotalTypeDict(){
        LinkedHashMap<String, EquipmentType> equipmentTotalTypeDict = new LinkedHashMap<>();
        for (EquipmentType type: equipmentTypeArrayList()) {
            equipmentTotalTypeDict.put(type.getEquipmentTypeId(), type);
        }
        return equipmentTotalTypeDict;
    }
    public LinkedHashMap<String, CommonEquipmentRepository<? extends Equipment>> equipmentRepositoryDict() {
        LinkedHashMap<String, CommonEquipmentRepository<? extends Equipment>> equipmentRepositoryDict = new LinkedHashMap<>();
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
    /*@Override
    public List<Equipment> findEquipmentByKind(String equipmentId) {
        for (Map.Entry<String, CommonEquipmentRepository<? extends Equipment>> entry : equipmentRepositoryDict().entrySet()) {
            CommonEquipmentRepository<? extends Equipment> repository = entry.getValue();
            List<? extends Equipment> equipment = repository.findEquipmentByKind(equipmentId);
            if (equipment != null) {
                return (List<Equipment>) equipment;
            }
        }
        return null;
    }

     */

    @Override
    public List<Equipment> findEquipmentByActiveOrderByName(boolean equipmentActive) {
        List<Equipment> equipmentList = new ArrayList<>();

        for (Map.Entry<String, CommonEquipmentRepository<? extends Equipment>> entry : equipmentRepositoryDict().entrySet()) {
            CommonEquipmentRepository<? extends Equipment> repository = entry.getValue();
            List<?> repositoryEquipmentList = repository.findEquipmentByActiveOrderByName(equipmentActive);
            for (Object item : repositoryEquipmentList) {
                equipmentList.add((Equipment) item);
            }
        }

        return equipmentList;
    }

}
