package com.immplan.injectionmanagement23.db.equipment.injectionmoldingmachine;


import com.immplan.injectionmanagement23.db.equipment.Equipment;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "spacer_plate")
public class SpacerPlate extends Equipment {
    public SpacerPlate(){
        super();
        setEquipmentTypeId("01.02");
    }

    @Column(name = "plate_height_mm", nullable = false)
    private Integer plateHeightMm;
    @Column(name = "plate_width_mm", nullable = false)
    private Integer plateWidthMm;
    @Column(name = "plate_length_mm", nullable = false)
    private Integer plateLengthMm;
    @Column(name = "plate_weight_kg")
    private Integer plateWeightKg;
    @Column(name = "plate_mount_time_min")
    private Integer plateMountTimeMin;
    @Column(name = "plate_release_time_min")
    private Integer plateReleaseTimeMin;
    @Column(name = "mounting_ring_diameter_mm")
    private Integer mountingRingDiameterMm;
    @Column(name = "mold_ring_diameter_mm")
    private Integer moldRingDiameterMm;
    @Column(name = "plate_mounted")
    @ColumnDefault("true")
    private boolean plateMounted;
    @ManyToOne(targetEntity = InjectionMoldingMachine.class)
    @JoinColumn(name = "plate_mounted_to", referencedColumnName = "equipment_id")
    private InjectionMoldingMachine plateMountedTo;

    public Integer getPlateHeightMm() {
        return plateHeightMm;
    }

    public void setPlateHeightMm(Integer plateHeightMm) {
        this.plateHeightMm = plateHeightMm;
    }

    public Integer getPlateWidthMm() {
        return plateWidthMm;
    }

    public void setPlateWidthMm(Integer plateWidthMm) {
        this.plateWidthMm = plateWidthMm;
    }

    public Integer getPlateLengthMm() {
        return plateLengthMm;
    }

    public void setPlateLengthMm(Integer plateLengthMm) {
        this.plateLengthMm = plateLengthMm;
    }

    public Integer getPlateWeightKg() {
        return plateWeightKg;
    }

    public void setPlateWeightKg(Integer plateWeightKg) {
        this.plateWeightKg = plateWeightKg;
    }

    public Integer getPlateMountTimeMin() {
        return plateMountTimeMin;
    }

    public void setPlateMountTimeMin(Integer plateMountTimeMin) {
        this.plateMountTimeMin = plateMountTimeMin;
    }

    public Integer getPlateReleaseTimeMin() {
        return plateReleaseTimeMin;
    }

    public void setPlateReleaseTimeMin(Integer plateReleaseTimeMin) {
        this.plateReleaseTimeMin = plateReleaseTimeMin;
    }

    public Integer getMountingRingDiameterMm() {
        return mountingRingDiameterMm;
    }

    public void setMountingRingDiameterMm(Integer mountingRingDiameterMm) {
        this.mountingRingDiameterMm = mountingRingDiameterMm;
    }

    public Integer getMoldRingDiameterMm() {
        return moldRingDiameterMm;
    }

    public void setMoldRingDiameterMm(Integer moldRingDiameterMm) {
        this.moldRingDiameterMm = moldRingDiameterMm;
    }

    public boolean isPlateMounted() {
        return plateMounted;
    }

    public void setPlateMounted(boolean plateMounted) {
        this.plateMounted = plateMounted;
    }

    public InjectionMoldingMachine getPlateMountedTo() {
        return plateMountedTo;
    }

    public void setPlateMountedTo(InjectionMoldingMachine plateMountedTo) {
        this.plateMountedTo = plateMountedTo;
    }
}
