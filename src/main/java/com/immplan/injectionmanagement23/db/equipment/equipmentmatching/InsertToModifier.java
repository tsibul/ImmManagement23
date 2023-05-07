package com.immplan.injectionmanagement23.db.equipment.equipmentmatching;


import com.immplan.injectionmanagement23.db.equipment.mold.MoldInsert;
import com.immplan.injectionmanagement23.db.equipment.mold.MoldModifier;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "insert_to_modifier")
public class InsertToModifier {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne(targetEntity = MoldInsert.class)
    @JoinColumn(name = "mold_insert", referencedColumnName = "equipment_id", nullable = false)
    private MoldInsert moldInsert;
    @ManyToOne(targetEntity = MoldModifier.class)
    @JoinColumn(name = "mold_modifier", referencedColumnName = "equipment_id", nullable = false)
    private MoldModifier moldModifier;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MoldInsert getMoldInsert() {
        return moldInsert;
    }

    public void setMoldInsert(MoldInsert moldInsert) {
        this.moldInsert = moldInsert;
    }

    public MoldModifier getMoldModifier() {
        return moldModifier;
    }

    public void setMoldModifier(MoldModifier moldModifier) {
        this.moldModifier = moldModifier;
    }
}
