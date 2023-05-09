package com.immplan.injectionmanagement23.db.technologyprocess;

import jakarta.persistence.*;

@Entity
@Table(name = "drying")
public class Drying {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driyng_id")
    private Long dryingId;

    public Long getDryingId() {
        return dryingId;
    }
}
