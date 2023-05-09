package com.immplan.injectionmanagement23.db.technologyprocess;

import jakarta.persistence.*;

@Entity
@Table(name = "clamping_unit")
public class ClampingUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clamping_unit_id")
    private Long clampingUnitId;

    public Long getClampingUnitId() {
        return clampingUnitId;
    }
}
