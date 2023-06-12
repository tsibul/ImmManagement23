package com.immplan.injectionmanagement23.db.equipment.materialseparator;

import com.immplan.injectionmanagement23.db.equipment.Equipment;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "material_separator")
public class MaterialSeparator extends Equipment {
    public MaterialSeparator(){
        super();
        setEquipmentType("03.09");
        setEquipmentKind("03");
    }
}
