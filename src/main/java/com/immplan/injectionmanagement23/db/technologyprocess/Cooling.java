package com.immplan.injectionmanagement23.db.technologyprocess;

import jakarta.persistence.*;

@Entity
@Table(name = "cooling")
public class Cooling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cooling_id")
    private Long coolingId;

    public Long getCoolingId() {
        return coolingId;
    }

    @Column(name = "delay", length = 5, nullable = false)
    private int delay = 0;

    @Column(name = "cooling", length = 3, nullable = false)
    private int cooling = 24;

    @Column(name = "cycleTime", length = 2, nullable = false)
    private int cycleTime = 31;

    @Column(name = "timeForExtract", length = 2, nullable = false)
    private int timeForExtract;

    @Column(name = "wholeCycleTime", length = 2, nullable = false)
    private int wholeCycleTime = 31;
}
