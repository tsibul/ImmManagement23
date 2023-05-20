package com.immplan.injectionmanagement23.db.defects;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Id;

@MappedSuperclass
public abstract class Defects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "defect_id")
    private Long defectId;
    @Column(name = "defect_description")
    private String defectDescription;
    @Column(name = "defect_reason")
    private String defectReason;
    @Column(name = "defect_active", columnDefinition = "boolean default true", nullable = false)
    private boolean defectActive = true;

    public Long getDefectId() {
        return defectId;
    }

    public void setDefectId(Long defectId) {
        this.defectId = defectId;
    }

    public String getDefectDescription() {
        return defectDescription;
    }

    public void setDefectDescription(String defectDescription) {
        this.defectDescription = defectDescription;
    }

    public String getDefectReason() {
        return defectReason;
    }

    public void setDefectReason(String defectReason) {
        this.defectReason = defectReason;
    }

    public boolean isDefectActive() {
        return defectActive;
    }

    public void setDefectActive(boolean defectActive) {
        this.defectActive = defectActive;
    }
}
