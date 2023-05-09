package com.immplan.injectionmanagement23.db.defects;

import jakarta.persistence.*;

@Entity
@Table(name = "material_defects")
public class MaterialDefects extends Defects{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "material_defects_id")
    private Long materialDefectsId;

    public Long getMaterialDefectsId() {
        return materialDefectsId;
    }
}
