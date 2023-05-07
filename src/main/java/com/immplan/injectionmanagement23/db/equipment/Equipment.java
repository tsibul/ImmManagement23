package com.immplan.injectionmanagement23.db.equipment;

import com.immplan.injectionmanagement23.db.producer.Producer;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Year;
import java.util.Date;

@MappedSuperclass
public abstract class Equipment {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "equipment_id")
    private Long equipmentId;
    @Column(nullable = false, name = "equipment_name")
    protected String equipmentName;
    @Column(length = 14, name = "inventory_code")
    private String inventoryCode;
    @ManyToOne(targetEntity = EquipmentKind.class)
    @JoinColumn(name = "equipment_kind", referencedColumnName = "kind_id", nullable = false)
    protected EquipmentKind equipmentKind;
    @ManyToOne(targetEntity = EquipmentType.class)
    @JoinColumn(name = "equipment_type", referencedColumnName = "type_id", nullable = false)
    private EquipmentType equipmentType;
    @Column(length = 2, name = "equipment_code")
    private String equipmentCode;
    @ManyToOne(targetEntity = Producer.class)
    @JoinColumn(name = "producer", referencedColumnName = "id")
    private Producer equipmentProducer;
    @Column(unique = true, name = "part_number")
    private String partNumber;
    @Column(length = 4, name = "year_production")
    private Year yearProduction;
    @Column(name = "receive_date")
    private Date receiveDate;

    public Long getEquipmentId() {
        return equipmentId;
    }

    public EquipmentKind getEquipmentKind() {
        return equipmentKind;
    }

    public void setEquipmentKind(EquipmentKind equipmentKind) {
        this.equipmentKind = equipmentKind;
    }

    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
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

    public Year getYearProduction() {
        return yearProduction;
    }

    public void setYearProduction(Year yearProduction) {
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

    public void setInventoryCode(String inventoryCode) {
        this.inventoryCode = this.equipmentKind.getKindCode() + "." + this.equipmentType.getTypeCode() + "." + this.equipmentCode;
    }

    public static interface EquipmentKindRepository extends JpaRepository<EquipmentKind, Long> {
    }
}
