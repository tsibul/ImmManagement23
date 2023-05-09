package com.immplan.injectionmanagement23.db.defects;

import jakarta.persistence.*;

@Entity
@Table(name = "molding_defects")
public class MoldingDefects extends Defects{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hydraulic_circuit_id")
    private Long moldingDefectsId;

    public Long getMoldingDefectsId() {
        return moldingDefectsId;
    }
}
