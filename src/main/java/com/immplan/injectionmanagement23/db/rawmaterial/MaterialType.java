package com.immplan.injectionmanagement23.db.rawmaterial;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "material_type")
public class MaterialType extends Material {
    @Column(name = "drying")
    private boolean drying;
    @Column(name = "drying_time", columnDefinition = "int default 0", nullable = false)
    private int materialDryingTime = 0;
    @Column(name = "driyng_temperature", columnDefinition = "int default 0", nullable = false)
    private int materialDryingTemperature = 0;

    public boolean isDrying() {
        return drying;
    }

    public void setDrying(boolean drying) {
        this.drying = drying;
    }

    public int getMaterialDryingTime() {
        return materialDryingTime;
    }

    public void setMaterialDryingTime(int materialDryingTime) {
        this.materialDryingTime = materialDryingTime;
    }

    public int getMaterialDryingTemperature() {
        return materialDryingTemperature;
    }

    public void setMaterialDryingTemperature(int materialDryingTemperature) {
        this.materialDryingTemperature = materialDryingTemperature;
    }
}
