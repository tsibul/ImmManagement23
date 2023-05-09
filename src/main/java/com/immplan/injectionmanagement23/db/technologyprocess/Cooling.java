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
}
