package com.immplan.injectionmanagement23.db.equipment.conveior;

import com.immplan.injectionmanagement23.db.equipment.Equipment;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "conveyor")
public class Conveyor extends Equipment {
    public Conveyor(){
        super();
        setEquipmentType("03.10");
        setEquipmentKind("03");
    }

}
