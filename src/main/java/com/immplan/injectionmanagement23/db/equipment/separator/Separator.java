package com.immplan.injectionmanagement23.db.equipment.separator;

import com.immplan.injectionmanagement23.db.equipment.Equipment;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "separator")
public class Separator extends Equipment {
    public Separator(){
        super();
        setEquipmentType("03.09");
        setEquipmentKind("03");
    }
}
