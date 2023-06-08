package com.immplan.injectionmanagement23.db.equipment;

import com.immplan.injectionmanagement23.db.producer.Producer;
import jakarta.persistence.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

import static com.immplan.injectionmanagement23.db.equipment.EquipmentKind.equipmentKindDict;
import static com.immplan.injectionmanagement23.db.equipment.EquipmentType.equipmentTypeDict;

@MappedSuperclass
public abstract class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "equipment_id")
    private Long equipmentId;
    @Column(nullable = false, name = "equipment_name")
    protected String equipmentName;
    @Column(length = 14, name = "inventory_code")
    private String inventoryCode;
    @Column(name = "equipment_kind_id", length = 2, nullable = false)
    private String equipmentKindId;
    @Column(name = "equipment_kind", length = 140, nullable = false)
    private String equipmentKind;
    @Column(name = "equipment_type_id", length = 5, nullable = false)
    private String equipmentTypeId;
    @Column(name = "equipment_type", length = 140, nullable = false)
    private String equipmentType;
    @Column(length = 2, name = "equipment_code")
    private String equipmentCode;
    @ManyToOne(targetEntity = Producer.class)
    @JoinColumn(name = "producer", referencedColumnName = "id")
    private Producer equipmentProducer;
    @Column(unique = true, name = "part_number")
    private String partNumber;
    @Column(length = 4, name = "year_production")
    private Date yearProduction;
    @Column(name = "receive_date")
    private Date receiveDate;
    @Column(name = "equipment_active", columnDefinition = "boolean default true", nullable = false)
    private boolean equipmentActive = true;

    public Long getEquipmentId() {
        return equipmentId;
    }

    public String getEquipmentKind() {
        return equipmentKind;
    }

    public void setEquipmentKind(String kindId){
        if(equipmentKindDict().get(kindId) != null)
        this.equipmentKindId = kindId;
        this.equipmentKind = equipmentKindDict().get(kindId);
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String typeId){
        if(equipmentTypeDict().get(typeId) != null)
            this.equipmentTypeId = typeId;
        this.equipmentType = equipmentTypeDict().get(typeId);
    }

    public String getEquipmentCode() {
        return equipmentCode;
    }

    public void setEquipmentCode(String equipmentCode) {
        this.equipmentCode = equipmentCode;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public Producer getEquipmentProducer() {
        return equipmentProducer;
    }

    public void setEquipmentProducer(Producer equipmentProducer) {
        this.equipmentProducer = equipmentProducer;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public void setEquipmentId(Long equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Date getYearProduction() {
        return yearProduction;
    }

    public void setYearProduction(Date yearProduction) {
        this.yearProduction = yearProduction;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public String getInventoryCode() {
        return inventoryCode;
    }

/*
    public void setInventoryCode(String inventoryCode) {
        this.inventoryCode = this.equipmentKind.getKindCode() + "." + this.equipmentType.getTypeCode() + "." + this.equipmentCode;
    }


 */
    public static interface EquipmentKindRepository extends JpaRepository<EquipmentKind, Long> {
    }

    public boolean isEquipmentActive() {
        return equipmentActive;
    }

    public void setEquipmentActive(boolean equipmentActive) {
        this.equipmentActive = equipmentActive;
    }
}
