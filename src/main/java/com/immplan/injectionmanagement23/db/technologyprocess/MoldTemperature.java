package com.immplan.injectionmanagement23.db.technologyprocess;

import jakarta.persistence.*;

@Entity
@Table(name = "mold_temperature")
public class MoldTemperature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mold_temperature_id")
    private Long moldTemperatureId;

    public Long getMoldTemperatureId() {
        return moldTemperatureId;
    }

    @Column(name = "puansonTemperature", length = 2, nullable = false)
    private int puansonTemperature;

    @Column(name = "matrixTemperature", length = 2, nullable = false)
    private int matrixTemperature;
}
