package com.immplan.injectionmanagement23.db.technologyprocess;

import jakarta.persistence.*;

@Entity
@Table(name = "controller_temperature")
public class ControllerTemperature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "controller_temperature_id")
    private Long controllerTemperatureId;

    public Long getControllerTemperatureId() {
        return controllerTemperatureId;
    }

    @Column(name = "zoneOne", length = 2, nullable = false)
    private int zoneOne;

    @Column(name = "zoneTwo", length = 2, nullable = false)
    private int zoneTwo;

    @Column(name = "zoneThree", length = 2, nullable = false)
    private int zoneThree;

    @Column(name = "zoneFour", length = 2, nullable = false)
    private int zoneFour;

    @Column(name = "zoneFive", length = 2, nullable = false)
    private int zoneFive;
}
