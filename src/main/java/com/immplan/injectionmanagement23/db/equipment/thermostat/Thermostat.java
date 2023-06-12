package com.immplan.injectionmanagement23.db.equipment.thermostat;

import com.immplan.injectionmanagement23.db.equipment.Equipment;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "thermostat")
public class Thermostat extends Equipment {
    public Thermostat(){
        super();
        setEquipmentType("03.03");
        setEquipmentKind("03");
    }
}