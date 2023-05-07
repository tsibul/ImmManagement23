package com.immplan.injectionmanagement23.db.equipment;


import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "equipment_kind")
public class EquipmentKind {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kind_id")
    private Long id;
    @Column(name = "kind_node", length = 40, nullable = false)
    private String kindName;
    @Column(name = "kind_code", length = 2, nullable = false)
    private String kindCode;


    public String getKindCode() {
        return kindCode;
    }

    public void setKindCode(String kindCode) {
        this.kindCode = kindCode;
    }

    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
