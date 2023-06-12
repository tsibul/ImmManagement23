package com.immplan.injectionmanagement23.db.equipment.loader;

import com.immplan.injectionmanagement23.db.equipment.Equipment;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "loader")
public class Loader extends Equipment {
    public Loader(){
        super();
        setEquipmentType("03.07");
        setEquipmentKind("03");
    }
}
