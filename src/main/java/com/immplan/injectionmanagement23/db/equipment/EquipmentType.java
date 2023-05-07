package com.immplan.injectionmanagement23.db.equipment;


import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "equipment_type")
public class EquipmentType {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private Long id;
    @Column(name = "type_name", length = 45)
    private String typeName;
    @Column(name = "type_code", length = 2)
    private String typeCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
