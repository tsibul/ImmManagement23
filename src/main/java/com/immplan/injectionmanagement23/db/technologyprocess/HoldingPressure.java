package com.immplan.injectionmanagement23.db.technologyprocess;

import jakarta.persistence.*;

@Entity
@Table(name = "holding_pressure")
public class HoldingPressure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "holding_pressure_id")
    private Long holdingPressureId;

    public Long getHoldingPressureIdd() {
        return holdingPressureId;
    }
}
