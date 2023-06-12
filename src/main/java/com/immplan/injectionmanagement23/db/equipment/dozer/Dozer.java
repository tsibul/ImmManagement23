package com.immplan.injectionmanagement23.db.equipment.dozer;

import com.immplan.injectionmanagement23.db.equipment.Equipment;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "dozer")
public class Dozer extends Equipment {
    public Dozer(){
        super();
        setEquipmentType("03.08");
        setEquipmentKind("03");
    }

}
