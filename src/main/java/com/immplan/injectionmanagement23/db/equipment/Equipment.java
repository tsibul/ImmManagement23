package com.immplan.injectionmanagement23.db.equipment;

import com.immplan.injectionmanagement23.db.producer.Producer;
import jakarta.persistence.*;
import java.util.Date;

import static com.immplan.injectionmanagement23.db.equipment.EquipmentKind.equipmentKindDict;
import static com.immplan.injectionmanagement23.db.equipment.EquipmentTypeRepository.equipmentTotalTypeDict;

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
    @Column(name = "equipment_type_id", length = 5, nullable = false)
    private String equipmentTypeId;
    @Column(length = 11, name = "equipment_code")
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

    public String getEquipmentCode() {
        return equipmentCode;
    }

    public void setEquipmentCode(String equipmentCode) {
        this.equipmentCode = equipmentCode;
    }

    public void setEquipmentTypeId(String equipmentTypeId) {
        this.equipmentTypeId = equipmentTypeId;
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

    public String getEquipmentTypeId() {
        return equipmentTypeId;
    }

    public boolean isEquipmentActive() {
        return equipmentActive;
    }

    public void setEquipmentActive(boolean equipmentActive) {
        this.equipmentActive = equipmentActive;
    }

    public void setInventoryCode(String inventoryCode) {
        this.inventoryCode = inventoryCode;
    }
}
