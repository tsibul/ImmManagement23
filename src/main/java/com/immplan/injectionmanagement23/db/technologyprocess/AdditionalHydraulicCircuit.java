package com.immplan.injectionmanagement23.db.technologyprocess;

import jakarta.persistence.*;

@Entity
@Table(name = "additional_hydraulic_circuit")
public class AdditionalHydraulicCircuit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hydraulic_circuit_id")
    private Long hydraulicCircuitId;

    public Long getHydraulicCircuitId() {
        return hydraulicCircuitId;
    }
}
