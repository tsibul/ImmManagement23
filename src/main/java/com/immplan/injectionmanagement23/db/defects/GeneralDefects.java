package com.immplan.injectionmanagement23.db.defects;

import jakarta.persistence.*;

@Entity
@Table(name = "general_defects")
public class GeneralDefects extends Defects{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "general_defects_id")
    private Long generalDefectsId;

    public Long getGeneralDefectsId() {
        return generalDefectsId;
    }
}
