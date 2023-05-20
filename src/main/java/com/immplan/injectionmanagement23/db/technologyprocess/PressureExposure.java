package com.immplan.injectionmanagement23.db.technologyprocess;

import jakarta.persistence.*;

@Entity
@Table(name = "pressure_exposure")
public class PressureExposure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pressure_exposure_id")
    private Long pressureExposureId;

    public Long getPressureExposureId() {
        return pressureExposureId;
    }

    @Column(name = "position", length = 2, nullable = false)
    private int position;

    @Column(name = "pressureOne", length = 2, nullable = false)
    private int pressureOne;

    @Column(name = "pressureTwo", length = 2, nullable = false)
    private int pressureTwo;

    @Column(name = "holdingSpeed", length = 2, nullable = false)
    private int holdingSpeed;

    @Column(name = "holdingTime", length = 2, nullable = false)
    private double holdingTime;

    @Column(name = "residualMelt", length = 6, nullable = false)
    private double residualMelt = 2.25;
}
