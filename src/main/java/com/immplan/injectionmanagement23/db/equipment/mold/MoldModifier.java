package com.immplan.injectionmanagement23.db.equipment.mold;


import com.immplan.injectionmanagement23.db.equipment.Equipment;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "mold_modifier")
public class MoldModifier extends Equipment {
    public MoldModifier() {
        super();
        setEquipmentTypeId("02.02");
    }

    @Column(name = "mold_weight_kg")
    private Integer moldWeightKg;
    @Column(name = "mold_height_mm")
    private Integer moldHeightMm;
    @Column(name = "if_air")
    @ColumnDefault("false")
    private boolean ifAir;
    @Column(name = "number_air_valves")
    private Integer numberAirValves;
    @Column(name = "if_hydraulic")
    @ColumnDefault("false")
    private boolean ifHydraulic;
    @Column(name = "number_hydraulic_cylinders")
    private Integer numberHydraulicCylinders;
    @Column(name = "if_changeable_insert")
    @ColumnDefault("false")
    private boolean ifChangeableInsert;
    @Column(name = "modifier_mount_time")
    private Integer modifierMountTime;
    @Column(name = "modifier_release_time")
    private Integer modifierReleaseTime;
    @Column(name = "single_modifier")
    @ColumnDefault("true")
    private boolean singleModifier;
    @Column(name = "modifier_mounted")
    @ColumnDefault("true")
    private boolean modifierMounted;
    @ManyToOne(targetEntity = MoldBase.class)
    @JoinColumn(name = "modifier_mounted_to", referencedColumnName = "equipment_id")
    private MoldBase modifierMountedTo;

    public boolean isModifierMounted() {
        return modifierMounted;
    }

    public void setModifierMounted(boolean modifierMounted) {
        if (!this.singleModifier) {
            this.modifierMounted = modifierMounted;
        } else {
            this.modifierMounted = true;
        }
    }

    public MoldBase getModifierMountedTo() {
        return modifierMountedTo;
    }

    public void setModifierMountedTo(MoldBase modifierMountedTo) {
        if (!this.singleModifier) {
            this.modifierMountedTo = modifierMountedTo;
        }
    }

    public Integer getMoldWeightKg() {
        return moldWeightKg;
    }

    public void setMoldWeightKg(Integer moldWeightKg) {
        this.moldWeightKg = moldWeightKg;
    }

    public Integer getMoldHeightMm() {
        return moldHeightMm;
    }

    public void setMoldHeightMm(Integer moldHeightMm) {
        this.moldHeightMm = moldHeightMm;
    }

    public boolean isIfAir() {
        return ifAir;
    }

    public void setIfAir(boolean ifAir) {
        this.ifAir = ifAir;
    }

    public boolean isIfHydraulic() {
        return ifHydraulic;
    }

    public void setIfHydraulic(boolean ifHydraulic) {
        this.ifHydraulic = ifHydraulic;
    }

    public Integer getNumberAirValves() {
        return numberAirValves;
    }

    public void setNumberAirValves(Integer numberAirValves) {
        this.numberAirValves = numberAirValves;
    }

    public Integer getNumberHydraulicCylinders() {
        return numberHydraulicCylinders;
    }

    public void setNumberHydraulicCylinders(Integer numberHydraulicCylinders) {
        this.numberHydraulicCylinders = numberHydraulicCylinders;
    }

    public boolean isIfChangeableInsert() {
        return ifChangeableInsert;
    }

    public void setIfChangeableInsert(boolean ifChangeableInsert) {
        this.ifChangeableInsert = ifChangeableInsert;
    }

    public Integer getModifierMountTime() {
        return modifierMountTime;
    }

    public void setModifierMountTime(Integer modifierMountTime) {
        this.modifierMountTime = modifierMountTime;
    }

    public Integer getModifierReleaseTime() {
        return modifierReleaseTime;
    }

    public void setModifierReleaseTime(Integer modifierReleaseTime) {
        this.modifierReleaseTime = modifierReleaseTime;
    }

    public boolean isSingleModifier() {
        return singleModifier;
    }

    public void setSingleModifier(boolean singleModifier) {
        this.singleModifier = singleModifier;
    }
}
