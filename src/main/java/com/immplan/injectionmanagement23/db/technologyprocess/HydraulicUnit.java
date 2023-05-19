package com.immplan.injectionmanagement23.db.technologyprocess;

import jakarta.persistence.*;

@Entity
@Table(name = "hydraulic_unit")
public class HydraulicUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hydraulic_unit_id")
    private Long hydraulicUnitId;

    public Long getHydraulicUnitId() {
        return hydraulicUnitId;
    }

    @Column(name = "pressureInput", length = 2, nullable = false)
    private double pressureInput;

    @Column(name = "speedInput", length = 2, nullable = false)
    private int speedInput;

    @Column(name = "positionInput", length = 2, nullable = false)
    private int positionInput;

    @Column(name = "timeInput", length = 2, nullable = false)
    private int timeInput;

    @Column(name = "pressureOutput", length = 2, nullable = false)
    private int pressureOutput;

    @Column(name = "speedOutput", length = 2, nullable = false)
    private int speedOutput;

    @Column(name = "positionOutput", length = 2, nullable = false)
    private int positionOutput;

    @Column(name = "timeOutput", length = 2, nullable = false)
    private int timeOutput;

}
