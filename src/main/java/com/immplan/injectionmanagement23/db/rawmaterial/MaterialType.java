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
    private Integer materialDryingTime = 0;
    @Column(name = "driyng_temperature", columnDefinition = "int default 0", nullable = false)
    private Integer materialDryingTemperature = 0;

    public boolean isDrying() {
        return drying;
    }

    public void setDrying(boolean drying) {
        this.drying = drying;
    }

    public Integer getMaterialDryingTime() {
        return materialDryingTime;
    }

    public void setMaterialDryingTime(Integer materialDryingTime) {
        this.materialDryingTime = materialDryingTime;
    }

    public Integer getMaterialDryingTemperature() {
        return materialDryingTemperature;
    }

    public void setMaterialDryingTemperature(Integer materialDryingTemperature) {
        this.materialDryingTemperature = materialDryingTemperature;
    }
}
