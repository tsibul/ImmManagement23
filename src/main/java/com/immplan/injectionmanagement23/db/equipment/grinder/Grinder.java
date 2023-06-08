package com.immplan.injectionmanagement23.db.equipment.grinder;


import com.immplan.injectionmanagement23.db.equipment.Equipment;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "grinder")
public class Grinder extends Equipment {
    public Grinder(){
        super();
        setEquipmentType("03.05");
        setEquipmentKind("03");
    }

}
