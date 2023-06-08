package com.immplan.injectionmanagement23.db.equipment.thermocontroller;


import com.immplan.injectionmanagement23.db.equipment.Equipment;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "thermo_controller")
public class ThermoController extends Equipment {
    public ThermoController(){
        super();
        setEquipmentType("03.04");
        setEquipmentKind("03");
    }

}
