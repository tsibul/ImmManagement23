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
}
