package com.immplan.injectionmanagement23.db.equipment.air;

import com.immplan.injectionmanagement23.db.equipment.Equipment;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "air_equipment")
public class AirEquipment extends Equipment {
    public AirEquipment(){
        super();
        setEquipmentTypeId("03.02");
    }

}
