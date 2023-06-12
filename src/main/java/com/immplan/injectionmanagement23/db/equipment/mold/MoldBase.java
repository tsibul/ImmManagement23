package com.immplan.injectionmanagement23.db.equipment.mold;


import com.immplan.injectionmanagement23.db.equipment.Equipment;
import com.immplan.injectionmanagement23.db.equipment.injectionmoldingmachine.InjectionMoldingMachine;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "mold_base")
public class MoldBase extends Equipment {
    public MoldBase(){
        super();
        setEquipmentType("02.01");
        setEquipmentKind("02");
    }
    @Column(name = "mold_base_width_mm")
    private Integer moldBaseWidthMm;
    @Column(name = "mold_base_length_mm")
    private Integer moldBaseLengthMm;
    @Column(name = "if_changeable_modifier")
    @ColumnDefault("false")
    private boolean ifChangeableModifier;
    @Column(name = "hot_runner")
    @ColumnDefault("false")
    private boolean hotRunner;
    @Column(name = "moving_plate_ring_diameter_mm")
    private Integer movingPlateRingDiameterMm;
    @Column(name = "fixed_plate_ring_diameter_mm")
    private Integer fixedPlateRingDiameterMm;
    @Column(name = "mold_mount_time_min")
    private Integer moldMountTimeMin;
    @Column(name = "mold_release_time_min")
    private Integer moldReleaseTimeMin;
    @Column(name = "mold_mounted")
    @ColumnDefault("true")
    private boolean moldMounted;
    @ManyToOne(targetEntity = InjectionMoldingMachine.class)
    @JoinColumn(name = "mold_mounted_to", referencedColumnName = "equipment_id")
    private InjectionMoldingMachine moldMountedTo;

    public boolean isMoldMounted() {
        return moldMounted;
    }

    public void setMoldMounted(boolean moldMounted) {
        this.moldMounted = moldMounted;
    }

    public InjectionMoldingMachine getMoldMountedTo() {
        return moldMountedTo;
    }

    public void setMoldMountedTo(InjectionMoldingMachine moldMountedTo) {
        this.moldMountedTo = moldMountedTo;
    }

    public Integer getMoldBaseWidthMm() {
        return moldBaseWidthMm;
    }

    public void setMoldBaseWidthMm(Integer moldBaseWidthMm) {
        this.moldBaseWidthMm = moldBaseWidthMm;
    }

    public Integer getMoldBaseLengthMm() {
        return moldBaseLengthMm;
    }

    public void setMoldBaseLengthMm(Integer moldBaseLengthMm) {
        this.moldBaseLengthMm = moldBaseLengthMm;
    }

    public boolean isIfChangeableModifier() {
        return ifChangeableModifier;
    }

    public void setIfChangeableModifier(boolean ifChangeableModifier) {
        this.ifChangeableModifier = ifChangeableModifier;
    }

    public boolean isHotRunner() {
        return hotRunner;
    }

    public void setHotRunner(boolean hotRunner) {
        this.hotRunner = hotRunner;
    }

    public Integer getMovingPlateRingDiameterMm() {
        return movingPlateRingDiameterMm;
    }

    public void setMovingPlateRingDiameterMm(Integer movingPlateRingDiameterMm) {
        this.movingPlateRingDiameterMm = movingPlateRingDiameterMm;
    }

    public Integer getFixedPlateRingDiameterMm() {
        return fixedPlateRingDiameterMm;
    }

    public void setFixedPlateRingDiameterMm(Integer fixedPlateRingDiameterMm) {
        this.fixedPlateRingDiameterMm = fixedPlateRingDiameterMm;
    }

    public Integer getMoldMountTimeMin() {
        return moldMountTimeMin;
    }

    public void setMoldMountTimeMin(Integer moldMountTimeMin) {
        this.moldMountTimeMin = moldMountTimeMin;
    }

    public Integer getMoldReleaseTimeMin() {
        return moldReleaseTimeMin;
    }

    public void setMoldReleaseTimeMin(Integer moldReleaseTimeMin) {
        this.moldReleaseTimeMin = moldReleaseTimeMin;
    }
}
