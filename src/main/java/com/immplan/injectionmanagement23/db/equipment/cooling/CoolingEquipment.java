package com.immplan.injectionmanagement23.db.equipment.cooling;

import com.immplan.injectionmanagement23.db.equipment.Equipment;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cooling_equipment")
public class CoolingEquipment extends Equipment {
    public CoolingEquipment(){
        super();
        setEquipmentType("03.01");
        setEquipmentKind("03");
    }

}
