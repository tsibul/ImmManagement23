package com.immplan.injectionmanagement23.db.equipment.equipmentmatching;


import com.immplan.injectionmanagement23.db.equipment.mold.MoldBase;
import com.immplan.injectionmanagement23.db.equipment.mold.MoldModifier;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "modifier_to_moldbase")
public class ModifierToMoldBase {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne(targetEntity = MoldModifier.class)
    @JoinColumn(name = "mold_modifier", referencedColumnName = "equipment_id", nullable = false)
    private MoldModifier moldModifier;
    @ManyToOne(targetEntity = MoldBase.class)
    @JoinColumn(name = "mold_base", referencedColumnName = "equipment_id", nullable = false)
    private MoldBase moldBase;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MoldModifier getMoldModifier() {
        return moldModifier;
    }

    public void setMoldModifier(MoldModifier moldModifier) {
        this.moldModifier = moldModifier;
    }

    public MoldBase getMoldBase() {
        return moldBase;
    }

    public void setMoldBase(MoldBase moldBase) {
        this.moldBase = moldBase;
    }
}
