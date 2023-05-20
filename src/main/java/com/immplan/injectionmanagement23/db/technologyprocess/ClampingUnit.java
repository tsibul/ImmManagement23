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

    @Column(name = "pressure", length = 3, nullable = false)
    private int pressure = 110;

    @Column(name = "closePhaseOne", length = 3, nullable = false)
    private int closePhaseOne = 240;

    @Column(name = "closePhaseTwo", length = 3, nullable = false)
    private int closePhaseTwo = 170;

    @Column(name = "closePhaseThree", length = 2, nullable = false)
    private int closePhaseThree = 3;

    @Column(name = "openPhaseOne", length = 2, nullable = false)
    private int openPhaseOne = 50;

    @Column(name = "openPhaseTwo", length = 3, nullable = false)
    private int openPhaseTwo = 300;

    @Column(name = "openPhaseThree", length = 3, nullable = false)
    private int openPhaseThree = 380;

    @Column(name = "startProtecting", length = 3, nullable = false)
    private int startProtecting = 160;

    @Column(name = "endProtecting", length = 5, nullable = false)
    private double endProtecting = 0.2;

    @Column(name = "effort", length = 5, nullable = false)
    private double effort = 0.8;

    @Column(name = "time", length = 5, nullable = false)
    private double time = 2.5;
}
