package com.immplan.injectionmanagement23.db.equipment.materialloader;

import com.immplan.injectionmanagement23.db.equipment.Equipment;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "loader")
public class MaterialLoader extends Equipment {
    public MaterialLoader(){
        super();
        setEquipmentType("03.07");
        setEquipmentKind("03");
    }
}