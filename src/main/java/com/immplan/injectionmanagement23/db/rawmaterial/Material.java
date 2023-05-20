package com.immplan.injectionmanagement23.db.rawmaterial;


import jakarta.persistence.*;

@MappedSuperclass
public abstract class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "material_id")
    private Long materialId;
    private String materialName;
    @Column(name = "material_active")
    private boolean materialActive = true;


    public Long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    @Override
    public String toString() {
        return "Material{" +
                "materialName='" + materialName + '\'' +
                '}';
    }

    public boolean isMaterialActive() {
        return materialActive;
    }

    public void setMaterialActive(boolean materialActive) {
        this.materialActive = materialActive;
    }
}

