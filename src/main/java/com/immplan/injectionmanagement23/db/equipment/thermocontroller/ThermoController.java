package com.immplan.injectionmanagement23.db.equipment.thermocontroller;


import com.immplan.injectionmanagement23.db.equipment.Equipment;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "thermo_controller")
public class ThermoController extends Equipment {
    public ThermoController(){
        super();
        setEquipmentTypeId("03.04");
    }

}
