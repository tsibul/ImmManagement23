package com.immplan.injectionmanagement23.db.technologyprocess;

import jakarta.persistence.*;

@Entity
@Table(name = "ejector")
public class Ejector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ejector_id")
    private Long ejectorId;

    public Long getEjectorId() {
        return ejectorId;
    }
}
