package com.immplan.injectionmanagement23.db.technologyprocess;

import jakarta.persistence.*;

@Entity
@Table(name = "drying")
public class Drying {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "drying_id")
    private Long dryingId;

    public Long getDryerId() {
        return dryingId;
    }

    @Column(name = "temperature", length = 3, nullable = false)
    private int temperature = 70;

    @Column(name = "hours", length = 2, nullable = false)
    private int hours = 6;
}
