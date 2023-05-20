package com.immplan.injectionmanagement23.db.technologyprocess;

import jakarta.persistence.*;

@Entity
@Table(name = "dryer")
public class Drying {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dryer_id")
    private Long dryingId;

    public Long getDryerId() {
        return dryingId;
    }

    @Column(name = "temperature", length = 2, nullable = false)
    private int temperature = 70;

    @Column(name = "hours", length = 2, nullable = false)
    private int hours = 6;
}
