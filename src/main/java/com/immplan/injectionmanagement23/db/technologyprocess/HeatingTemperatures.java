package com.immplan.injectionmanagement23.db.technologyprocess;

import jakarta.persistence.*;

@Entity
@Table(name = "heating_temperatures")
public class HeatingTemperatures {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "heating_temperatures_id")
    private Long heatingTemperaturesId;

    public Long getHeatingTemperaturesId() {
        return heatingTemperaturesId;
    }

    @Column(name = "zoneFive", length = 3, nullable = false)
    private int zoneFive;

    @Column(name = "zoneFour", length = 3, nullable = false)
    private int zoneFour;

    @Column(name = "zoneThree", length = 3, nullable = false)
    private int zoneThree;

    @Column(name = "zoneTwo", length = 3, nullable = false)
    private int zoneTwo;

    @Column(name = "zoneOne", length = 3, nullable = false)
    private int zoneOne;

    @Column(name = "zoneLoad", length = 3, nullable = false)
    private int zoneLoad;
}
