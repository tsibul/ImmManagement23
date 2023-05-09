package com.immplan.injectionmanagement23.db.technologyprocess;

import jakarta.persistence.*;

@Entity
@Table(name = "injection")
public class Injection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "injection_id")
    private Long injectionId;

    public Long getInjectionId() {
        return injectionId;
    }
}
