package com.immplan.injectionmanagement23.db.equipment.dryer;

import com.immplan.injectionmanagement23.db.equipment.Equipment;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "dryer")
public class Dryer extends Equipment {
    public Dryer(){
        super();
        setEquipmentType("03.06");
        setEquipmentKind("03");
    }

}
