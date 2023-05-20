package com.immplan.injectionmanagement23.db.defects;

import com.immplan.injectionmanagement23.db.equipment.EquipmentKind;
import com.immplan.injectionmanagement23.db.rawmaterial.MaterialType;
import jakarta.persistence.*;

@Entity
@Table(name = "material_defects")
public class MaterialDefects extends Defects{
    @ManyToOne(targetEntity = MaterialType.class)
    @JoinColumn(name = "material_type", referencedColumnName = "material_id")
    protected EquipmentKind material_type;
}
