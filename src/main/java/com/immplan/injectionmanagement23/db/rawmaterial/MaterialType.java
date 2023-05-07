package com.immplan.injectionmanagement23.db.rawmaterial;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "material_type")
public class MaterialType extends Material{
    @Column(name = "drying")
    private boolean drying;

    public boolean isDrying() {
        return drying;
    }

    public void setDrying(boolean drying) {
        this.drying = drying;
    }
}
